package calculate;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.lang.Math;
import main.WebNode;

public class recommend_movie {
	private ArrayList<String> lst;
	//台灣2006年後的電影 
	public recommend_movie() {
		this.lst = new ArrayList<String>();
		lst.add("詭絲");
		lst.add("盛夏光年");
		lst.add("一年之初");
		lst.add("國士無雙");
		lst.add("我的逍遙學伴");
		lst.add("人魚朵朵");
		lst.add("巧克力重擊");
		lst.add("單車上路");
		lst.add("奇蹟的夏天");
		lst.add("夢想無限");
		lst.add("色，戒");
		lst.add("不能說的秘密");
		lst.add("練習曲");
		lst.add("刺青");
		lst.add("天堂口");
		lst.add("六號出口");
		lst.add("基因決定我愛你");
		lst.add("沉睡的青春");
		lst.add("海之傳說－媽祖");
		lst.add("黑眼圈");
		lst.add("愛麗絲的鏡子");
		lst.add("松鼠自殺事件");
		lst.add("夏天的尾巴");
		lst.add("穿牆人");
		lst.add("松鼠自殺事件");
		lst.add("我看見獸");
		lst.add("指間的重量");
		lst.add("最遙遠的距離");
		lst.add("奇妙的旅程");
		lst.add("幫幫我愛神");
		lst.add("紅氣球");
		lst.add("功夫灌籃");
		lst.add("流浪神狗人");
		lst.add("九降風");
		lst.add("蝴蝶");
		lst.add("鬪茶");
		lst.add("漂浪青春");
		lst.add("海角七號");
		lst.add("囧男孩");
		lst.add("花吃了那女孩");
		lst.add("一八九五");
		lst.add("渺渺");	
		lst.add("停車");
		lst.add("鈕扣人");
		lst.add("對不起，我愛你");
		lst.add("愛到底");
		lst.add("練戀舞");
		lst.add("絕命派對");
		lst.add("星月無盡");
		lst.add("白銀帝國");
		lst.add("陽陽");
		lst.add("不能沒有你");
		lst.add("聽說");
		lst.add("夏天協奏曲");
		lst.add("帶我去遠方");
		lst.add("臉");
		lst.add("一席之地");
		lst.add("淚王子");
		lst.add("刺陵");
		lst.add("艋舺");
		lst.add("靠岸");
		lst.add("眼淚");
		lst.add("一頁台北");
		lst.add("獵豔");
		lst.add("混混天團");
		lst.add("乘著光影旅行");
		lst.add("鑑真大和尚");
		lst.add("台北星期天");
		lst.add("第36個故事");
		lst.add("有一天");
		lst.add("愛你一萬年");
		lst.add("戀愛通告");
		lst.add("近在咫尺");
		lst.add("父後七日");
		lst.add("酷馬");
		lst.add("第四張畫");
		lst.add("劍雨");
		lst.add("當愛來的時候");
		lst.add("初戀風暴");
		lst.add("茱麗葉");
		lst.add("彈簧床先生");
		lst.add("大笑江湖");
		lst.add("雞排英雄");
		lst.add("憶世界大冒險");
		lst.add("青春啦啦隊");
		lst.add("與愛別離");
		lst.add("帶一片風景走");
		lst.add("命運化妝師");
		lst.add("殺手歐陽盆栽");
		lst.add("河豚");
		lst.add("翻滾吧！阿信");
		lst.add("那些年，我們一起追的女孩");
		lst.add("賽德克·巴萊(上)：太陽旗");
		lst.add("五月天3DNA");
		lst.add("賽德克·巴萊(下)：彩虹橋");
		lst.add("燃燒吧！歐吉桑");
		lst.add("阿爸");
		lst.add("皮克青春");
		lst.add("星空");
		lst.add("電哪吒");
		lst.add("牽阮的手");
		lst.add("不一樣的月光");
		lst.add("樂之路");
		lst.add("戀愛恐慌症");
		lst.add("10+10");
		lst.add("痞子英雄首部曲：全面開戰");
		lst.add("龍飛鳳舞");
		lst.add("陣頭");
		lst.add("新天生一對");
		lst.add("寶島大爆走");
		lst.add("愛的麵包魂");
		lst.add("愛");
		lst.add("熊熊愛上你");
		lst.add("昨日的記憶");
		lst.add("飲食男女2：好遠又好近");
		lst.add("愛");
		lst.add("女孩壞壞");
		lst.add("什麼鳥日子");
		lst.add("Z-108棄城");
		lst.add("不倒翁的奇幻旅程");
		lst.add("臺北飄雪");
		lst.add("為你而來");
		lst.add("白天的星星");
		lst.add("貧民英雄");
		lst.add("腳趾上的星光");
		lst.add("寶米恰恰");
		lst.add("寶島雙雄");
		lst.add("手機裡的眼淚");
		lst.add("女朋友。男朋友");
		lst.add("BBS鄉民的正義");
		lst.add("犀利人妻最終回：幸福男·不難");
		lst.add("球來就打");
		lst.add("騷人");
		lst.add("西門町");
		lst.add("變羊記");
		lst.add("逆光飛翔");
		lst.add("南方小羊牧場");
		lst.add("花漾");
		lst.add("幸福三角地");
		lst.add("變身");
		lst.add("親愛的奶奶");
		lst.add("大尾鱸鰻");
		lst.add("逗陣ㄟ");
		lst.add("志氣");
		lst.add("天后之戰");
		lst.add("阿嬤的夢中情人");
		lst.add("港都");
		lst.add("明天記得愛上我");
		lst.add("台灣黑狗兄");
		lst.add("天台");
		lst.add("世界第一麥方");
		lst.add("瑪德2號");
		lst.add("總舖師");
		lst.add("失魂");
		lst.add("戀戀海灣");
		lst.add("你的今天和我的明天");
		lst.add("拔一條河");
		lst.add("被偷走的那五年");
		lst.add("5月天諾亞方舟");
		lst.add("對面的女孩殺過來");
		lst.add("聽見下雨的聲音");
		lst.add("一首搖滾上月球");
		lst.add("我是隻小小鳥");
		lst.add("現場·戰場·夢工場");
		lst.add("看見台灣");
		lst.add("幸福快遞");
		lst.add("夢見");
		lst.add("秋香");
		lst.add("十二夜");
		lst.add("愛情無全順");
		lst.add("暑假作業");
		lst.add("甜蜜殺機");
		lst.add("鐵獅玉玲瓏");
		lst.add("大稻埕");
		lst.add("郊遊");
		lst.add("KANO");
		lst.add("白米炸彈客");
		lst.add("媽祖迺台灣");
		lst.add("到不了的地方");
		lst.add("愛在墾丁─痞子遇到愛");
		lst.add("行動代號：孫中山");
		lst.add("冰毒");
		lst.add("等一個人咖啡");
		lst.add("海上皇宮");
		lst.add("大宅們");
		lst.add("軍中樂園");
		lst.add("痞子英雄：黎明再起");
		lst.add("想飛");
		lst.add("寒蟬效應");
		lst.add("餘生—賽德克·巴萊");
		lst.add("逆轉勝");
		lst.add("太平輪：亂世浮生");
		lst.add("相愛的七種設計");
		lst.add("極光之愛");
		lst.add("十萬夥急");
		lst.add("很久沒有敬我了妳");
		lst.add("奇人密碼－古羅布之謎");
		lst.add("大囍臨門");
		lst.add("鐵獅玉玲瓏2");
		lst.add("史明·革命進行式");
		lst.add("念念");
		lst.add("台北夜遊團團轉");
		lst.add("沙西米");
		lst.add("五月一號");
		lst.add("五月一號");
		lst.add("缺角一族");
		lst.add("角頭");
		lst.add("愛琳娜");
		lst.add("醉·生夢死");
		lst.add("我的少女時代");
		lst.add("234說愛你");
		lst.add("紅衣小女孩");
		lst.add("我們全家不太熟");
		lst.add("神廚");
		lst.add("大尾鱸鰻2");
		lst.add("我們的那時此刻");
		lst.add("獨一無二");
		lst.add("只要我長大");
		lst.add("五星級魚干女");
		lst.add("奇幻同學會");
		lst.add("黑白");
		lst.add("傻瓜向錢衝");
		lst.add("六弄咖啡館");
		lst.add("萌學園：尋找磐古");
		lst.add("極樂宿舍");
		lst.add("樓下的房客");
		lst.add("大顯神威");
		lst.add("一萬公里的約定");
		lst.add("德布西森林");
		lst.add("紅衣小女孩2");
		lst.add("血觀音");
		lst.add("吃吃的愛");
		lst.add("帶我去月球");
		lst.add("小貓巴克里");
		lst.add("翻滾吧！男人");
		lst.add("畢業旅行笑翻天");
		lst.add("大佛普拉斯");
		lst.add("老師，你會不會回來？");
		lst.add("地圖的盡頭");
		lst.add("台北物語");
		lst.add("報告老師！怪怪怪怪物！");
		lst.add("比悲傷更悲傷的故事");
		lst.add("角頭2：王者再起");
		lst.add("花甲大人轉男孩");
		lst.add("人面魚：紅衣小女孩外傳");
		lst.add("誰先愛上他的");
		lst.add("粽邪");
		lst.add("鬥魚");
		lst.add("切小金家的旅館");
		lst.add("幸福路上");
		lst.add("後勁：王建民");
		lst.add("返校");
		lst.add("第九分局");
		lst.add("寒單");
		lst.add("陽光普照");
		lst.add("大三元");
		lst.add("下半場");
		lst.add("老大人");
		lst.add("陪你很久很久");
		lst.add("致親愛的孤獨者");
		lst.add("孤味");
		lst.add("刻在你心底的名字");
		lst.add("可不可以，你也剛好喜歡我");
		lst.add("馗降：粽邪2");
		lst.add("女鬼橋");
		lst.add("無聲");
		lst.add("打噴嚏");
		lst.add("怪胎");
		lst.add("同學麥娜絲");
		lst.add("親愛的房客");
		lst.add("當男人戀愛時");
		lst.add("月老");
		lst.add("角頭－浪流連");
		lst.add("聽見歌 再唱");
		lst.add("緝魂");
		lst.add("我沒有談的那場戀愛");
		lst.add("瀑布");
		lst.add("叱咤風雲");
		lst.add("再說一次我願意");
		lst.add("妖果小學－水果奶奶的大秘密");
		lst.add("我吃了那男孩一整年的早餐");
		lst.add("咒");
		lst.add("一家之主");
		lst.add("他還年輕");
		lst.add("想見你");
		lst.add("山中森林");
		lst.add("關於我和鬼變成家人的那件事");
		lst.add("黑的教育");
		lst.add("我的麻吉4個鬼");
		lst.add("周處除三害");
		lst.add("老狐狸");
		lst.add("粽邪3:鬼門開");
	}
	public ArrayList<String> find_synonym(String s)
	{
		ArrayList<String> similar_list=new ArrayList<String>();
		for (String k : lst)
		{
			int limitValue = Math.max(Math.min(k.length(),s.length()), 3);
			int lcs = findLCS(k, s);
			//System.out.println(limitValue);
			//System.out.println("lsc"+lcs);
			//如果lcs的配對字數大於輸入字串或者電影列表裡的字的字數長度，則視輸入字串k為相似詞
			if (lcs >= limitValue-2)
			{
				similar_list.add(k);
			}
		}
		return similar_list;
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
	public static void print_out(ArrayList<String> lst) {
		if (lst.size() ==0){
			System.out.println("no similar movie");
		}
		else {
			for (String k : lst) {
				System.out.println(k);
			}
		}
	}
}
