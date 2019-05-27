package qu_70;

public class Solution {
	public int climbStairs(int n) {
		if(n==0)return 0;
		if(n==1)return 1;
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int result=s.climbStairs(6);
		System.out.println(result);
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
