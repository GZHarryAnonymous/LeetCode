package qu_115;
import java.util.Scanner;
public class Solution3 {
	public int numDistinct(String s, String t) {
		int t_len = t.length();
		int s_len = s.length();
		if(s_len<t_len)return 0;
		int dp[][]=new int[t_len+1][s_len+1];
		for(int i=0;i<=s_len;i++){
			dp[0][i]=1;
		}
		for(int i=1;i<=t_len;i++){
			for(int j=1;j<=s_len;j++){
				if(t.charAt(i-1)==s.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
				}else {
					dp[i][j]=dp[i][j-1];
				}
			}
		}
		return dp[t_len][s_len];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		//Scanner sc = new Scanner(System.in);
		//String a = sc.next();
		//String b = sc.next();
		String a = "babgbag";
		String b = "bag";
		int result=s.numDistinct(a,b);
		System.out.println(result);
	}
}