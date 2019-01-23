package qu_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public boolean isMatch(String s, String p) {
		int s_len = s.length(), p_len = p.length();
		if (p_len == 0)
			return s_len == 0;
		boolean[][] dp = new boolean[p_len + 1][s_len + 1];
		dp[0][0] = true;
		int k = 1;
		while (k < p_len) {
			if (p.charAt(k) == '*') {
				dp[k][0] = true;
				if (k + 1 > p_len)
					break;
				dp[k + 1][0] = true;
			} else {
				break;
			}
			k += 2;
		}
		for (int i = 1; i <= p_len; i++) {
			if (p.charAt(i - 1) == '*') {
				if (i == p_len)
					break;
				i++;
			}
			for (int j = 1; j <= s_len; j++) {
				boolean curMatch = p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.';
				if (i < p_len && p.charAt(i) == '*') {
					dp[i][j] = dp[i - 1][j] || (curMatch && (dp[i][j - 1] || dp[i - 1][j - 1]));
					dp[i + 1][j] = dp[i][j];
				} else {
					dp[i][j] = curMatch && dp[i - 1][j - 1];
				}
			}
		}
		return dp[p_len][s_len];
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
