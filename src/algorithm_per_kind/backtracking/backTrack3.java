package algorithm_per_kind.backtracking;

//https://blog.csdn.net/sinat_27908213/article/details/80599460
public class backTrack3 {
	public static void main(String[] args) {
		String s = "abc";
		pailie(s, "");
	}

	public static void pailie(String s, String temp) {//参数设计地尽量地简洁
		if (s.length() == 0) {
			System.out.println(temp);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String news = s.substring(0, i) + s.substring(i + 1, s.length());//去掉String中的某个字母
			pailie(news, temp + s.charAt(i));
		}
	}
}

/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/