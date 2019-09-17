package qu_44;

// ？ 匹配任意单个字符（小写字母）  * 匹配0到多个任意字符（串）
// 输入 原字符串p   和    模式字符串s，比较输出 false or true

/**
 * 动态规划：
 * 自底向上或者自顶向下。
 * 备忘录模式，自顶向下思路：
 * 	if p[j]=='?' or p[j] == s[i]  then dp[i][j]=dp[i-1][j-1].
 * 	if p[j]=='*' then dp[i][j]=dp[i][j-1] or dp[i-1][j]
 */
public class Solution3 {
	public boolean isMatch(String s, String p) {
		// 字符串转字符数组。
		char[] s_char = s.toCharArray();
		char[] p_char = p.toCharArray();
		int i = 0;
		int j = 0;
		int star_start = -1;
		int s_k = 0; // 记录最后一次匹配的位置  + 1

		while (i < s.length()) {
			if (j < p.length() && (s_char[i] == p_char[j] || p_char[j] == '?')) {
				++i;
				++j;
				continue;
			}

			if (j < p.length() && p_char[j] == '*') {
				star_start = j++;
				s_k = i;
				continue;
			}

			// 如果失配了，回溯到 k + 1，即让 * 再多吞噬一个字符。
			if (star_start != -1) {
				i = ++s_k;// 让 * 再多吞噬一个字符
				j = star_start + 1;// 然后 * 的下一个开始比较
				continue;
			}
			return false;
		}

		while (j < p.length() && p_char[j] == '*') ++j;

		return j == p.length();
	}
	public static void main(String args[]) {
		Solution3 solve = new Solution3();
		String s = "aa";
		String p = "*";
		boolean result=solve.isMatch(s,p);
		System.out.println(result);
	}
}

