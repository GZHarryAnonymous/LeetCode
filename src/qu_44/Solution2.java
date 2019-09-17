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
public class Solution2 {
	public boolean isMatch(String s, String p) {
		int s_len = s.length(),p_len=p.length();
		boolean[][] dp = new boolean[s_len+1][p_len+1];
		// 边界赋值。
		// s="" && p=""
		dp[0][0]=true;
		// p=""
		for(int i=1;i<=s_len;i++){
			dp[i][0]=false;
		}
		// s=""
		for(int j=1;j<=p_len;j++){
			dp[0][j]=dp[0][j-1]&&p.charAt(j-1)=='*';
		}
		// s为行，p为列，画一下分析，p应该在外层循环。
		for(int j=1;j<=p_len;j++){
			for(int i=1;i<=s_len;i++){
				// 状态转移方程。
				if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
					dp[i][j]=dp[i-1][j-1];
				}else if(p.charAt(j-1)=='*'){
					dp[i][j]=dp[i-1][j]||dp[i][j-1];
				}
			}
		}
		return dp[s_len][p_len];
	}
	public static void main(String args[]) {
		Solution2 solve = new Solution2();
		String s = "aa";
		String p = "*";
		boolean result=solve.isMatch(s,p);
		System.out.println(result);
	}
}

