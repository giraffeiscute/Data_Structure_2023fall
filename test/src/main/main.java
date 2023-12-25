package main;

import java.util.Timer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.text.GapContent;

import calculate.WebNodeList;
import calculate.WebTree;
import calculate.recommend_movie;
import calculate.synonym_finder;
import calculate.traversal_PostOrder;


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
      //用PostOrder計算積分webnode1
        synonym_finder words_set = new synonym_finder();
		for (int i=0;i<parentArray.size();i++) {
			if (words_set.find_synonym(parentArray.get(i))==1) {
				System.out.println("remove " + parentArray.get(i).webPage.name);
				parentArray.remove(i);
			}
        }
		
		//評分
        WebNodeList WebNodess = new WebNodeList();
        for (WebNode parent : parentArray) {
    		WebTree tree1 = new WebTree(parent);
    		traversal_PostOrder p1 = new traversal_PostOrder(tree1);
    		p1.traversal();
    		System.out.println(parent.nodeScore);
    		WebNodess.add(parent);
        }
		WebNodess.sort();
		//印出排序後的list
		WebNodess.output();
		
		//推薦搜尋
		recommend_movie rMovie = new recommend_movie();
		recommend_movie.print_out(rMovie.find_synonym(keyword));
		
    }
    
}