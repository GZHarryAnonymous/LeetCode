package qu_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		StringBuilder result = new StringBuilder();
		int i = 0;
		char cmp;
		while (true) {
			if (strs[0].length() > i) {
				cmp = strs[0].charAt(i);
			} else {
				return result.toString();
			}
			for (String str : strs) {
				if (str.length() <= i)
					return result.toString();
				char c = str.charAt(i);
				if (cmp != c) {
					return result.toString();
				}
			}
			result.append(cmp);
			i++;
		}

	}

	public static void main(String args[]) {
		MySolution s = new MySolution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * 相关说明： 基于LeetCode平台算法的一个刷题记录！ 已经共享至public repository，链接如下：
 * https://github.com/GZHarryAnonymous/LeetCode
 * 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 * 个人博客：https://gzharryanonymous.github.io/ 欢迎来访！当然，如果来访还打赏就更好啦！！！ 能力有限，希望有帮到你！
 **/
