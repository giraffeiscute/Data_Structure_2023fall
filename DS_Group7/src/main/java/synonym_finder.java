import java.util.ArrayList;

import javax.swing.text.html.HTML.Tag;

public class synonym_finder {
 //設立剔除在搜尋引擎外的字列
 public ArrayList<String> lst;
 public synonym_finder()
 {
  this.lst = new ArrayList<String>();
  lst.add("金句");
  lst.add("维基百科");
  lst.add("線上看");
  lst.add("電影排名");
  lst.add("辭典");
  lst.add("wiki");
  lst.add("WIKI");
  lst.add("维基百科");
  lst.add("Facebook");
  lst.add("facebook");
  lst.add("netflix");
 }
 public synonym_finder(ArrayList<String> list) {
  lst=list;
 }
 public int find_synonym(WebNode webnode)
 {
  int tag = 0;
  for (String k : lst)
  {
   int limitValue = k.length();
   int lcs = findLCS(k, webnode.webPage.name);
   int lcs1 = findLCS(k, webnode.webPage.url);
   //System.out.println(limitValue);
   //System.out.println("lsc"+lcs);
   //如果lcs的配對字數大於字本身則視輸入字串k為相似詞
   if (lcs >= limitValue)
   {
    tag += 1;
   }
   if (lcs1 >= limitValue)
   {
    tag += 1;
   }
  }
  return tag;
 }

 //LCS 演算法
 public int findLCS(String x, String y)
 {
  int n = x.length();
  int m = y.length();
  int[][] L = new int[n+1][m+1];
  for(int i=0;i<n+1;i++) {
   L[i][0]=0;
  }
  for(int j=0;j<m+1;j++) {
   L[0][j]=0;
  }
  for(int i=0;i<n;i++) {
   for(int j=0;j<m;j++) {
    //System.out.println(x.charAt(i)+" and "+y.charAt(j));
    if(x.charAt(i)==y.charAt(j)) {
     //System.out.println(x.charAt(i)+" and "+y.charAt(j));
    L[i+1][j+1]=L[i][j]+1;
    }
    else {
     L[i+1][j+1] = Math.max(L[i+1][j],L[i][j+1]);
    }
   }
  }
  //printMatrix(L);
  //System.out.println("next");
  return L[n][m];
 }
}