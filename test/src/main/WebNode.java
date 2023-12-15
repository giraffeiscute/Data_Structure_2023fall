package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WebNode
{
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;
	public double nodeScore;// This node's score += all its children's nodeScore
	
	public WebNode(WebPage webPage)
	{	
		this.webPage = webPage;
		this.children = new ArrayList<WebNode>();
	}
	
	public WebNode(WebPage webPage,WebNode parent)
	{	this.parent = parent;
		this.webPage = webPage;
		this.children = new ArrayList<WebNode>();
	}
	
	public void exploreNodeContent(String keyWord, int currentDepth, int depthLimit) throws IOException {
	    if (currentDepth > depthLimit) {
	        return; // 终止递归，超过深度限制
	    }

	    // 获取该节点对应的网页内容
	    Crawler childCrawler = new Crawler(webPage.url);
	    HashMap<String, String> childSearchResults = childCrawler.query();

	    // 创建子节点并添加到当前节点的子节点列表中
	    for (String childTitle : childSearchResults.keySet()) {
	        String childUrl = childSearchResults.get(childTitle);
	        WebPage childWebPage = new WebPage(childUrl, childTitle);
	        WebNode childWebNode = new WebNode(childWebPage, this);
	        addChild(childWebNode);

	        // 递归调用 exploreNodeContent 方法，深度挖掘每个子节点
	        childWebNode.exploreNodeContent(keyWord, currentDepth + 1, depthLimit);
	    }
	}
//	public void setNodeScore(ArrayList<Keyword> keywords) throws IOException
//	{
//		// YOUR TURN
//		// 2. calculate the score of this node
//		// this method should be called in post-order mode
//
//		// You should do something like:
//		// 		1.compute the score of this webPage
//		// 		2.set this score to initialize nodeScore
//		//		3.nodeScore must be the score of this webPage 
//		//		  plus all children's nodeScore
//		  webPage.setScore(keywords);
//		    nodeScore = webPage.score;
//
//		    // Add scores of all children
//		    for (WebNode child : children) {
//		        child.setNodeScore(keywords);
//		        nodeScore += child.nodeScore;}
//	}

	public void addChild(WebNode child)
	{
		// add the WebNode to its children list
		this.children.add(child);
		child.parent = this;
	}

	public boolean isTheLastChild()
	{
		if (this.parent == null)
			return true;
		ArrayList<WebNode> siblings = this.parent.children;

		return this.equals(siblings.get(siblings.size() - 1));
	}

	public int getDepth()
	{
		int retVal = 1;
		WebNode currNode = this;
		while (currNode.parent != null)
		{
			retVal++;
			currNode = currNode.parent;
		}
		return retVal;
	}
}