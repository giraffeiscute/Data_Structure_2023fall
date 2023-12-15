package main;
import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	
	public String url;
	public String name;

	public WebPage(String url, String name)
	{
		this.url = url;
		this.name = name;
	}
}
//	public void setScore(ArrayList<Keyword> keywords) throws IOException
//	{
//		score = 0;
//		// YOUR TURN
////		1. calculate the score of this webPage
//		for (Keyword keyword : keywords) {
//	        int keywordCount = counter.countKeyword(keyword.name);
//	        score += keywordCount * keyword.weight;
//	       }
//	}

