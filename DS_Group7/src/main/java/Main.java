import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*; 

@WebServlet("/Main")
public class Main extends HttpServlet {
  
    public static void main(String[] args) throws IOException {
     Scanner scanner = new Scanner(System.in);
    
        // 讓使用者輸入關鍵字和要抓取的結果數量
        String keyword = getValidInput("請輸入關鍵字: ", "[a-zA-Z\\u4e00-\\u9fa5]+", "請輸入中文或英文");
        int numberOfResults = Integer.parseInt(getValidInput("請輸入要抓取的結果數量: ", "\\d+", "請輸入數字"));

        ArrayList<WebNode> parentArray=new ArrayList<WebNode>();
        try {
        
         // 使用 WebCrawler 類別爬取網站標題、連結和內容
         parentArray = WebCrawler.crawlWeb(keyword+"影評", numberOfResults);


        
         

            // 在這裡你可以進一步處理 parentArray，例如印出資訊或進行其他操作
            for (WebNode parent : parentArray) {
                System.out.println("Parent Title: " + parent.webPage.name);
                System.out.println("Parent URL: " + parent.webPage.url);
                //System.out.println("Parent Content:\n" + parent.content);

                // 檢查是否有子節點
                if (!parent.children.isEmpty()) {
                    System.out.println("Children:");

                    for (WebNode child : parent.children) {
                        System.out.println("\tChild Title: " + child.webPage.name);
                        System.out.println("\tChild URL: " + child.webPage.url);
                        //System.out.println("\tChild Content:\n" + child.content);
                    }
                }

                System.out.println("----------------------------");
            }
        }catch (Exception e) {
            if (e instanceof java.net.SocketTimeoutException) {
                // 處理連線超時的情況
                System.err.println("連線超時: " + e.getMessage());
            } else if (e instanceof java.net.UnknownHostException) {
                // 處理無法找到主機的情況
                System.err.println("找不到主機: " + e.getMessage());
            } else if (e instanceof java.io.FileNotFoundException) {
                // 處理找不到檔案的情況
                System.err.println("找不到檔案: " + e.getMessage());
            } else {
                // 其他IOException情況
             System.err.println("發生未知例外: " + e.getMessage());
            }

            e.printStackTrace();
        }
       

        // 關閉 Scanner
        scanner.close();
        // 用PostOrder計算積分webnode1
        synonym_finder words_set = new synonym_finder();
        Iterator<WebNode> iterator = parentArray.iterator();
        while (iterator.hasNext()) {
            WebNode node = iterator.next();
            if (words_set.find_synonym(node) == 1) {
                System.out.println("remove " + node.webPage.name);
                iterator.remove();
            }
        }
  
        // 評分
        WebNodeList WebNodess = new WebNodeList();
        for (WebNode parent : parentArray) {
            try {
                WebTree tree1 = new WebTree(parent);
                traversal_PostOrder p1 = new traversal_PostOrder(tree1);
                p1.traversal();
                //System.out.println(parent.nodeScore);
                
                WebNodess.add(parent);
            } catch (Exception e) {
             e.printStackTrace();
            }
        }
        if (WebNodess.is_zero()== true){
         System.out.println("no movie related result");
        }
        else {
  WebNodess.sort();
  //印出排序後的list
  WebNodess.output();
  System.out.println("----------------------------");
        }
  
  //推薦搜尋
  recommend_movie rMovie = new recommend_movie();
  recommend_movie.print_out(rMovie.find_synonym(keyword));
  
    }
    
    private static String getValidInput(String prompt, String regex, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                return input;
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        
        // 檢查關鍵字是否為空
        if (request.getParameter("keyword") == null) {
            // 如果關鍵字為空，返回到搜索頁面
            String requestUri = request.getRequestURI();
            request.setAttribute("requestUri", requestUri);
            request.getRequestDispatcher("search.jsp").forward(request, response);
            return;
        }
        
        // Retrieve the keyword parameter from the request
        String keyword = request.getParameter("keyword");
        

        // Set a default value for the number of times to crawl
        int times = 20;

        // Use WebCrawler to fetch web information
        ArrayList<WebNode> parentArray = WebCrawler.crawlWeb(keyword, times);
        
        // 用PostOrder計算積分webnode1
        synonym_finder words_set = new synonym_finder();
        Iterator<WebNode> iterator = parentArray.iterator();
        while (iterator.hasNext()) {
            WebNode node = iterator.next();
            if (words_set.find_synonym(node) >= 1) {
                System.out.println("remove " + node.webPage.name);
                iterator.remove();
            }
        }
  
        // 評分
        WebNodeList WebNodess = new WebNodeList();
        for (WebNode parent : parentArray) {
            try {
                WebTree tree1 = new WebTree(parent);
                traversal_PostOrder p1 = new traversal_PostOrder(tree1);
                p1.traversal();
                //System.out.println(parent.nodeScore);
                
                //System.out.println(parent.nodeScore != 0.0);
             if (parent.nodeScore != 0.0) {
              WebNodess.add(parent);
              }
            } catch (Exception e) {
             e.printStackTrace();
            }
        }

        if (WebNodess.is_zero()== true){
         System.out.println("no movie related result");
        }
        else {
  WebNodess.sort();
  //印出排序後的list
  WebNodess.output();
  System.out.println("----------------------------");
        }
        LinkedHashMap<String, String> b = new LinkedHashMap<String, String>();

  //印出排序後的list
  for (int i=0;i<WebNodess.size();i++)  {
   b.put(WebNodess.get(i).webPage.name, WebNodess.get(i).webPage.url);
  }
  //推薦搜尋
  recommend_movie rMovie = new recommend_movie();
  recommend_movie.print_out(rMovie.find_synonym(keyword));
  
  ArrayList<String> rMovieRecommendations = rMovie.find_synonym(keyword);
  

        // Set the result in the request attribute to be accessed by the JSP page
        request.setAttribute("filteredList", b);
        
        request.setAttribute("recommendations", rMovieRecommendations);

        // Forward the request and response to the JSP page
        request.getRequestDispatcher("result1.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // For simplicity, let's just delegate the handling to the doGet method
        doGet(request, response);
    }
}