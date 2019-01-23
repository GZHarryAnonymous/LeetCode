package q_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public String longestPalindrome(String s) {
		int len = s.length();
		int start = 0, end = 0, result = 1, tag1 = 0, tag2 = 0;
		if (s == null || len == 0)
			return "";
		for (int i = 0; i < len; i++) {
			int ans1 = expandOnCenter(i, i, len, s);
			if (ans1 >= result) {
				result = ans1;
				tag1 = i;
				tag2 = i;
			}
			if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
				int ans2 = expandOnCenter(i, i + 1, len, s);
				if (ans2 >= result) {
					result = ans2;
					tag1 = i;
					tag2 = i + 1;
				}
			}
		}
		if (tag1 == tag2) {
			return s.substring(tag1 - result / 2, tag2 + result / 2 + 1);
		} else {
			return s.substring(tag2 - result / 2, tag1 + result / 2 + 1);
		}
	}

	private int expandOnCenter(int start, int end, int len, String s) {
		while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return end - start - 1;

	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * 相关说明： 基于LeetCode平台算法的一个刷题记录！ 已经共享至public repository，链接如下：
 * https://github.com/GZHarryAnonymous/LeetCode 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 * 个人博客：https://gzharryanonymous.github.io/ 欢迎来访！当然，如果来访还打赏就更好啦！！！ 能力有限，希望有帮到你！
 **/
