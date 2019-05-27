package qu_152;

public class Solution2 {
	public int maxProduct(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		int[][] dp = new int[2][len];
		int result=0;
		dp[0][0]=nums[0];
		dp[1][0]=nums[0];
		for(int i=1;i<len;i++){
			dp[0][i]=Math.min(nums[i],Math.min(dp[0][i-1]*nums[i],dp[1][i-1]*nums[i]));// 0,i代表负数 1,i代表正数
			dp[1][i]=Math.max(nums[i],Math.max(dp[0][i-1]*nums[i],dp[1][i-1]*nums[i]));// 0,i代表负数 1,i代表正数
			if(dp[1][i]>result)result=dp[1][i];
		}
		return Math.max(nums[0],result);
	}
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[] nums = {0,2};
		int result=s.maxProduct(nums);
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
