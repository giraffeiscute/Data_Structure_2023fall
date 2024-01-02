package main;

import java.io.IOException;
import java.util.ArrayList;


public class traversal_PostOrder {
	public WebTree tree;
	public ArrayList<Keyword> keywords;
	
	public traversal_PostOrder(WebTree T) {
		this.keywords = new ArrayList<Keyword>();
		Keyword keyword1 = new Keyword("導演", 1.2);
		Keyword keyword2 = new Keyword("劇情", 1.8);
		Keyword keyword3 = new Keyword("演員", 2.1);
		Keyword keyword4 = new Keyword("配樂", 1.2);
		Keyword keyword5 = new Keyword("觀後", 5);
		Keyword keyword6 = new Keyword("Audience", 1.2);
		Keyword keyword7 = new Keyword("Critic", 1.2);
		Keyword keyword8 = new Keyword("Review", 1.2);
		Keyword keyword9 = new Keyword("Director", 5);
		Keyword keyword10 = new Keyword("Rating", 1.2);
		Keyword keyword11 = new Keyword("Cast", 5);
		
		keywords.add(keyword1);
		keywords.add(keyword2);
		keywords.add(keyword3);
		keywords.add(keyword4);
		keywords.add(keyword5);
		keywords.add(keyword6);
		keywords.add(keyword7);
		keywords.add(keyword8);
		keywords.add(keyword9);
		keywords.add(keyword10);
		keywords.add(keyword11);
		
		tree = T;
	}

	public void traversal()
	{
		try {
			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		catch(Exception e)
		{System.out.print("error on traveral");}
		}
	}


