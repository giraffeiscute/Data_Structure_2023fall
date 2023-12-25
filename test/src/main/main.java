package main;

import java.util.Timer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.text.GapContent;


public class main {
	public static void main(String[] args) 
	{ 
		//讀取要搜尋的電影名稱
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入電影名稱：");
        String movieTitle = scanner.nextLine();
		Keyword keyword =new Keyword(movieTitle,0);
		scanner.close();
		
		
		//建立parents的ArrayList<WebNode>
		WebNodeList Parents_Array = new WebNodeList();
		//執行搜索
		Crawler crawler = new Crawler(movieTitle,2);//建立Crawler所需要的變數
		
		//////將搜尋結果存成WebNode
		try 
        {
            // 获取搜索结果
            HashMap<String, String> searchResults = crawler.query();
            int count = 0;
            // 遍历搜索结果，将标题和 URL 存入 Vector
            for (String title : searchResults.keySet()) 
            {
                String url = searchResults.get(title);
                WebPage webPage = new WebPage(title,url);
                WebNode webNode = new WebNode(webPage);
                Parents_Array.add(webNode);
                try {
                	System.out.println("正在爬第 "+count+" 筆資料");
                    Thread.sleep(5000);
                    count+=1;
                	  }
                catch(InterruptedException e) {
                	         }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		// Iterate through Parents_Array
		for (WebNode webNode : Parents_Array) {
		    // Print the information
		    System.out.println("Title: " + webNode.webPage.name + " , URL: " + webNode.webPage.url);
		}
		
		///////抓child
		//執行搜索
		//Crawler crawler_child = new Crawler(movieTitle,2);//建立Crawler所需要的變數
				
		for (WebNode webNode_parent : Parents_Array) {
			Crawler crawler_child = new Crawler(movieTitle,webNode_parent.webPage.url,2);//建立Crawler所需要的變數
			
					try 
			        {
			            // 获取搜索结果
			            HashMap<String, String> searchResults = crawler_child.query();
			            int count = 0;
			            // 遍历搜索结果，将标题和 URL 存入 Vector
			            for (String title : searchResults.keySet()) 
			            {
			                String url = searchResults.get(title);
			                WebPage webPage = new WebPage(title,url);
			                WebNode webNode_child = new WebNode(webPage);
			                webNode_parent.addChild(webNode_child);//定childe的parent
			                webNode_parent.children.add(webNode_child);//把子網頁加到webNode的children array裡面
			                
			                try {
			                	System.out.println("正在爬childern第 "+count+" 筆資料");
			                    Thread.sleep(5000);
			                    count+=1;
			                	  }
			                catch(InterruptedException e) {
			                	         }
			                
			            }
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
					
					
				    // Print the information
				    //System.out.println("Title: " + webNode.webPage.name + " , URL: " + webNode.webPage.url);
				}
		for (WebNode webNodeP : Parents_Array) {
		    // Print the information
			for (WebNode webNodeC : webNodeP.children) {
			    // Print the information
			    System.out.println("Title: " + webNodeC.webPage.name + " , URL: " + webNodeC.webPage.url);
			}
		}
		
		
		
//		// 我把webpage的輸入方式放相反 以便debug
//		//手動創建之webnode 1
//		WebPage WebPage1 = new WebPage("第二十二期-海角七號觀後感/曾立雯 - 國立國父紀念館","https://www.yatsen.gov.tw/information_154_93964.html&sa=U&ved=2ahUKEwjt2ID9_pWDAxWAa_UHHWURDnQQFnoECAMQAg&usg=AOvVaw0GM_l5Z9_MoSHWIHQ5jQ3y");
//		WebPage WebPage_wiki = new WebPage("海角七號 - 維基百科","https://zh.wikipedia.org/zh-tw/%25E6%25B5%25B7%25E8%25A7%2592%25E4%25B8%2583%25E8%2599%259F&sa=U&ved=2ahUKEwjt2ID9_pWDAxWAa_UHHWURDnQQFnoECAQQAg&usg=AOvVaw1Fj1gI89pEFAheDWncucZF");
//		WebPage WebPage_child1 = new WebPage("《海角七號》造夢者— OPENTIX兩廳院文化生活","https://www.opentix.life/event/1676779546528456704&sa=U&ved=2ahUKEwjt2ID9_pWDAxWAa_UHHWURDnQQFnoECAUQAg&usg=AOvVaw3ZPeQSp7ARC3oNa2RP5xHv");
//		WebPage WebPage_child2 = new WebPage("「海角七號」當年為何暴紅？網回憶「這句話」太經典：北漂人的心聲","https://tw.news.yahoo.com/%E6%B5%B7%E8%A7%92%E4%B8%83%E8%99%9F-%E7%95%B6%E5%B9%B4%E7%82%BA%E4%BD%95%E6%9A%B4%E7%B4%85-%E7%B6%B2%E5%9B%9E%E6%86%B6-%E9%80%99%E5%8F%A5%E8%A9%B1-%E5%A4%AA%E7%B6%93%E5%85%B8-032500175.html?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8&guce_referrer_sig=AQAAAKMV51fZPJveiKWuE45aKlrqYLZuQwrijKJvrEnq2twhBK6qBWjxIg9_rZsFVNx-RBckBVMyj3jcViVqNuDMZKT8knYdJNmyj6CnXWtn4YzkfJOn3J4W5mb_nWGto6ocYJ2xhZoi75glqVPbi_4_eH18o4oiJKTv80kV4EHBGjvL");
//		WebNode webnode1 = new WebNode(WebPage1);
//		WebNode webnode_wiki = new WebNode(WebPage_wiki);
//		WebNode webnode_child1 = new WebNode(WebPage_child1);
//		WebNode webnode_child2 = new WebNode(WebPage_child2);
//		webnode1.addChild(new WebNode(new WebPage("Publication","http://soslab.nccu.edu.tw/Publications.html")));
//		webnode1.addChild(new WebNode(new WebPage("socisal","http://soslab.nccu.edu.tw/Projects.html")));
//		webnode1.addChild(webnode_child1);
//		webnode1.addChild(webnode_child2);
//		
//		//手動創建之webnode 2
//		WebNode webnode2 = new WebNode(WebPage1);
//		webnode2.addChild(new WebNode(new WebPage("Publication","http://soslab.nccu.edu.tw/Publications.html")));
//		webnode2.addChild(new WebNode(new WebPage("socisal","http://soslab.nccu.edu.tw/Projects.html")));
//		webnode2.addChild(webnode_child1);
//		//手動創建之webnode 3
//		WebNode webnode3 = new WebNode(WebPage1);
//		webnode3.addChild(new WebNode(new WebPage("Publication","http://soslab.nccu.edu.tw/Publications.html")));
//		webnode3.addChild(new WebNode(new WebPage("socisal","http://soslab.nccu.edu.tw/Projects.html")));
//		
//		//判斷相近詞
//		Synonym_finder words_set = new Synonym_finder();
//		int a = words_set.find_synonym(webnode_wiki);
//		System.out.println(a);
//		
//		//用PostOrder計算積分webnode1
//		WebTree tree1 = new WebTree(webnode1);
//		Traversal_PostOrder p1 = new Traversal_PostOrder(tree1);
//		p1.traversal();
//		
//		//用PostOrder計算積分webnode2
//		WebTree tree2 = new WebTree(webnode2);
//		Traversal_PostOrder p2 = new Traversal_PostOrder(tree2);
//		p2.traversal();
//		
//		//用PostOrder計算積分webnode3
//		WebTree tree3 = new WebTree(webnode3);
//		Traversal_PostOrder p3 = new Traversal_PostOrder(tree3);
//		p3.traversal();
//		
//		WebNodeList WebNodes = new WebNodeList();
//		System.out.println(webnode3.nodeScore);
//		System.out.println(webnode2.nodeScore);
//		System.out.println(webnode1.nodeScore);
//		WebNodes.add(webnode2);
//		WebNodes.add(webnode3);
//		WebNodes.add(webnode1);
//		
//		//用 quickSort 的方式排序
//		WebNodes.sort();
//		//印出排序後的list
//		WebNodes.output();
//		
//		
//		System.out.println("end");
	}
}