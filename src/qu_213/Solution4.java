package qu_213;

public class Solution4 {
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		int dp[][] = new int[2][len+1];
		dp[0][0]=0;dp[0][1]=0;//i=0表示第一个不要
		dp[1][0]=0;dp[1][1]=nums[0];//i=1表示第一个要
		for(int i=2;i<=len;i++) {
			dp[0][i] = Math.max(dp[0][i-2] + nums[i-1], dp[0][i-1]);
			dp[1][i] = Math.max(dp[1][i-2] + nums[i-1], dp[1][i-1]);
		}
		return Math.max(dp[0][len],dp[1][len-1]);//第一个不要和最后一个不要哪一个大
	}

	public static void main(String args[]) {
		Solution4 s = new Solution4();
		int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int result=s.rob(nums);
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
