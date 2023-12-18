package calculate;

public class Main {
	public static void main(String[] args) 
	{ 
		// 我把webpage的輸入方式放相反 以便debug
		WebPage WebPage1 = new WebPage("第二十二期-海角七號觀後感/曾立雯 - 國立國父紀念館","https://www.yatsen.gov.tw/information_154_93964.html&sa=U&ved=2ahUKEwjt2ID9_pWDAxWAa_UHHWURDnQQFnoECAMQAg&usg=AOvVaw0GM_l5Z9_MoSHWIHQ5jQ3y");
		WebPage WebPage_wiki = new WebPage("海角七號 - 維基百科","https://zh.wikipedia.org/zh-tw/%25E6%25B5%25B7%25E8%25A7%2592%25E4%25B8%2583%25E8%2599%259F&sa=U&ved=2ahUKEwjt2ID9_pWDAxWAa_UHHWURDnQQFnoECAQQAg&usg=AOvVaw1Fj1gI89pEFAheDWncucZF");
		WebPage WebPage_child1 = new WebPage("《海角七號》造夢者— OPENTIX兩廳院文化生活","https://www.opentix.life/event/1676779546528456704&sa=U&ved=2ahUKEwjt2ID9_pWDAxWAa_UHHWURDnQQFnoECAUQAg&usg=AOvVaw3ZPeQSp7ARC3oNa2RP5xHv");
		WebNode webnode = new WebNode(WebPage1);
		WebNode webnode_wiki = new WebNode(WebPage_wiki);
		WebNode webnode_child1 = new WebNode(WebPage_child1);
		webnode.addChild(new WebNode(new WebPage("Publication","http://soslab.nccu.edu.tw/Publications.html")));
		webnode.addChild(new WebNode(new WebPage("socisal","http://soslab.nccu.edu.tw/Projects.html")));
		webnode.addChild(webnode_child1);
		synonym_finder words_set = new synonym_finder();
		int a = words_set.find_synonym(webnode_wiki);
		System.out.println(a);
		WebTree tree = new WebTree(webnode);
		

		traversal_PostOrder p = new traversal_PostOrder(tree);
		p.traversal();
		
	}
}
