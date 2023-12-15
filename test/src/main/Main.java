package main;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;
public class Main 
{
	public static void main(String[] args) 
	{ 
		//讀取要搜尋的電影名稱
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入電影名稱：");
        String movieTitle = scanner.nextLine();
		Keyword keyword =new Keyword(movieTitle);
		scanner.close();
		
		
		
		//執行搜索
		Crawler crawler = new Crawler(movieTitle);//建立Crawler所需要的變數
		//把搜尋的頁面當成WebPage並且設為root
		WebPage rootPage = new WebPage(crawler.url,crawler.encoededKeyword);
		WebTree webTree = new WebTree(rootPage);
		WebNode rootNode = new WebNode(rootPage);
		
		try 
        {
            // 获取搜索结果
            HashMap<String, String> searchResults = crawler.query();
            
            // 创建一个 Vector 用于存储标题和 URL
            Vector<WebNode> WebNodes = new Vector<WebNode>();
            
            // 遍历搜索结果，将标题和 URL 存入 Vector
            for (String title : searchResults.keySet()) 
            {
                String url = searchResults.get(title);
                WebPage webPage = new WebPage(url,title);
                WebNode webNode = new WebNode(webPage,rootNode);
//                // 深度挖掘每个节点的内容
//                webNode.exploreNodeContent(crawler.encoededKeyword,1,3);
                WebNodes.add(webNode);
                
                
            }
            
         // 打印 Vector 中的内容
            for (WebNode webNode : WebNodes) {
                System.out.println("Title: " + webNode.webPage.name + " , URL: " + webNode.webPage.url);
//             // 打印每个子节点的内容
//                for (WebNode child : webNode.children) {
//                    System.out.println("\tChild - Title: " + child.webPage.name + " , URL: " + child.webPage.url);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
