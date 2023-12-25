package main;

import java.util.Timer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.text.GapContent;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讓使用者輸入關鍵字和要抓取的結果數量
        System.out.print("請輸入關鍵字: ");
        String keyword = scanner.nextLine();

        System.out.print("請輸入要抓取的結果數量: ");
        int numberOfResults = scanner.nextInt();

        // 使用 WebCrawler 類別爬取網站標題、連結和內容
        ArrayList<WebNode> parentArray = WebCrawler.crawlWeb(keyword, numberOfResults);

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

        // 關閉 Scanner
        scanner.close();
    }
}