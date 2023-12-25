package main;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Timer;

import java.io.IOException;
import java.util.ArrayList;
class WebCrawler {
    public static ArrayList<WebNode> crawlWeb(String keyword, int numberOfResults) {
        ArrayList<WebNode> parentArray = new ArrayList<>();

        try {
            // 使用 Jsoup 連接並解析 Google 搜尋結果頁面
            String searchUrl = "https://www.google.com/search?q=" + keyword;
            Document doc = Jsoup.connect(searchUrl).get();

            // 取得搜尋結果的標題和連結
            Elements searchResults = doc.select("div.tF2Cxc");

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
                WebPage WebPage =new WebPage(title, url);
                WebNode webNode = new WebNode(WebPage);
                
                // 創建 WebNode 並加入 parentArray
                //WebNode node = new WebNode(title, url, null, 0, content);
                parentArray.add(webNode);

                try {
                    System.out.println("正在爬第 " + count + " 筆資料");
                    Thread.sleep(1500);
                    count += 1;
                } catch (InterruptedException e) {
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

                    // 爬取子網站的文字內容
                    String subContent = crawlContent(subUrl);

                    // 創建子 WebNode 並加入 subNodes，同時設定 parent
                    WebPage subWebPage =new WebPage(subTitle, subUrl);
                    WebNode subNode = new WebNode(subWebPage);
                    parent.addChild(subNode);
                    try {
                        System.out.println("正在爬child第 " + subCount + " 筆資料");
                        Thread.sleep(1500);
                        subCount += 1;
                    } catch (InterruptedException e) {
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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