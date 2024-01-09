import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebCrawler {
    public static ArrayList<WebNode> crawlWeb(String keyword, int numberOfResults) {
        ArrayList<WebNode> parentArray = new ArrayList<>();

        try {
            // 使用 Jsoup 連接並解析 Google 搜尋結果頁面
            String searchUrl = "https://www.google.com/search?q=" + keyword+"影評";
            Document doc = Jsoup.connect(searchUrl).get();

            // 更新搜尋結果的選擇器
            Elements searchResults = doc.select("div.g");

            System.out.println(numberOfResults+" "+searchResults.size());
            // 確保不超過指定的結果數量
            int resultsToFetch = Math.min(numberOfResults, searchResults.size());

            int count = 0;
            for (int i = 0; i < resultsToFetch; i++) {
                Element result = searchResults.get(i);
                String title = result.select("h3").text();
                String url = result.select("a").attr("href");

                // 爬取網站的文字內容
                String content = crawlContent(url);

                // 創建子 WebNode 並加入 subNodes，同時設定 parent
                WebPage webPage = new WebPage(title, url);
                WebNode webNode = new WebNode(webPage);

                // 創建 WebNode 並加入 parentArray
                parentArray.add(webNode);

                try {
                    System.out.println("正在爬第 " + count + " 筆資料");
                    Thread.sleep(100);
                    count += 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 對每個 WebNode 爬取子頁面的標題、連結和文字內容
            crawlSubNodes(parentArray, 2); // 2是數量

        } catch (IOException e) {
            e.printStackTrace();
        }

        return parentArray;
    }

    private static void crawlSubNodes(ArrayList<WebNode> parentArray, int maxSubNodes) {
        int subCount = 0;
        // 使用 HashSet 來確保子節點的唯一性
        HashSet<String> visitedUrls = new HashSet<>();

        for (WebNode parent : parentArray) {
            try {
                Document subDoc = Jsoup.connect(parent.webPage.url).get();
                Elements subLinks = subDoc.select("a[href]");

                // 確保不超過指定的子節點數量
                int subNodesToFetch = Math.min(maxSubNodes, subLinks.size());

                for (int i = 0; i < subNodesToFetch; i++) {
                    Element subLink = subLinks.get(i);
                    String subTitle = subLink.text();
                    String subUrl = subLink.attr("abs:href");

                    // 確保子節點的唯一性
                    if (!visitedUrls.contains(subUrl) && isValidUrl(subUrl)) {
                        visitedUrls.add(subUrl);

                        // 爬取子網站的文字內容
                        String subContent = crawlContent(subUrl);

                        // 創建子 WebNode 並加入 subNodes，同時設定 parent
                        WebPage subWebPage = new WebPage(subTitle, subUrl);
                        WebNode subNode = new WebNode(subWebPage);
                        parent.addChild(subNode);

                        try {
                            System.out.println("正在爬child第 " + subCount + " 筆資料");
                            Thread.sleep(100);
                            subCount += 1;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            // URL 格式異常，視為無效
         System.out.println("URL 格式異常，視為無效");
            return false;
        }
    }

    private static String crawlContent(String url) {
        try {
            Document contentDoc = Jsoup.connect(url).get();
            // 在這裡你可以根據網站的 HTML 結構選擇要抓取的內容
            return contentDoc.text(); // 使用 .text() 只抓取文字內容
        } catch (IOException e) {
            e.printStackTrace();
            return ""; // 如果發生錯誤，返回空字串
        }
    }
}