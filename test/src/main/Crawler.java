package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Random;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler 
{
	public String searchKeyword;
	public String encoededKeyword;
	public String url;
	public String content;//儲存該網址的HTML
	
	//建構子，並把keyword用UTF-8編碼
	public Crawler(String searchKeyword, int times)
	{
		this.searchKeyword = searchKeyword;
		try 
		{
			this.encoededKeyword=java.net.URLEncoder.encode(searchKeyword,"utf-8");
			this.url = "https://www.google.com/search?q="+this.encoededKeyword+"&oe=utf8&num=" + times;//20是搜索數量
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	 // 新建構子，用來抓取子網頁的內容
	public Crawler(String searchKeyword, String url, int times) {
		this.searchKeyword = searchKeyword;
		try 
		{
			this.encoededKeyword=java.net.URLEncoder.encode(searchKeyword,"utf-8");
			this.url = url.replaceAll("/url\\?esrc=s&q=&rct=j&sa=U&url=", "");
			System.out.print(this.url);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	
	String[] userAgents = {
		    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3",
		    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3",
		    // 添加更多 User-Agent 字符串...
		};
	// 随机选择一个 User-Agent
	String randomUserAgent = userAgents[new Random().nextInt(userAgents.length)];

	//回傳一個網頁的原始HTML檔案
	private String fetchContent() throws IOException
	{
		//回傳值
		String retVal = "";
		try {
		URL u = new URL(url);
		URLConnection conn = u.openConnection();//通過 URL 物件打開一個連接
		//set HTTP header
		conn.setRequestProperty("User-agent", randomUserAgent);

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");//創建讀取器
		BufferedReader bufReader = new BufferedReader(inReader);//把讀取到的東西變成bufreader的形式
		String line = null;

		while((line = bufReader.readLine()) != null)
		{
			retVal += line;
		}
		 
    } catch (IOException e) {
        System.err.println("Error reading content from URL: " + e.getMessage());
        e.printStackTrace();
    }
		return retVal;
	}
	
	//
	public HashMap<String, String> query() throws IOException
	{
		if(content == null)
		{
			content = fetchContent();//此時content是HTML
		}

		HashMap<String, String> retVal = new HashMap<String, String>();//return的形式是 標題+網址
		
		//using Jsoup analyze html string
		Document doc = Jsoup.parse(content);//把content的HTML用jsoup解析，Document是jsoup儲存HTML的type
		
		//select particular element(tag) which you want 
		Elements lis = doc.select("div");//lis是doc中符合doc.select("div")的部分
		lis = lis.select(".kCrYT");//lis是html中包含kCrYT跟div的部分
		
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.select("a").get(0).attr("href").replace("/url?q=", "");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				
				if(title.equals("")) 
				{
					continue;
				}
				
				//put title and pair into HashMap
				retVal.put(title, citeUrl);

			} catch (IndexOutOfBoundsException e) 
			{
//				e.printStackTrace();
			}
		}
		
		return retVal;
	}
}