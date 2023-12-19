package calculate;

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
		keywords.add(keyword1);
		keywords.add(keyword2);
		keywords.add(keyword3);
		keywords.add(keyword4);
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


