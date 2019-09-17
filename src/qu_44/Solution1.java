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
public class Solution1 {
	int dp[][];
	public boolean pan(String p,int j){
		while (j<p.length()){
			if(p.charAt(j++)!='*')return false;
		}
		return true;
	}
 	public boolean compare(String s, String p,int i,int j){
		boolean res = false;
		if(s.length()==i)res = p.length()==j || pan(p,j);
		if(i<s.length()&&j<p.length()){
				if(dp[i][j]==1)return true;
				if(dp[i][j]==2)return false;
				if(p.charAt(j)=='?'|| p.charAt(j)==s.charAt(i)){
					res = compare(s,p,i+1,j+1);
				}else if(p.charAt(j)=='*'){
					res = compare(s,p,i+1,j) || compare(s,p,i,j+1) || compare(s,p,i+1,j+1);
				}
			if(res){
				dp[i][j]=1;
			}else {
				dp[i][j]=2;
			}
		}
        return res;
	}
	public boolean isMatch(String s, String p) {
		dp = new int[s.length()][p.length()];
		return compare(s,p,0,0);
	}
	public static void main(String args[]) {
		Solution1 solve = new Solution1();
		String s = "a";
		String p = "a*";
		boolean result=solve.isMatch(s,p);
		System.out.println(result);
	}
}

