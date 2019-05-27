package qu_53;
public class Solution {
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		if(len == 0)return 0;
		int[] dp = new int[len];
		dp[0] = nums[0];
		int result = dp[0];
		for(int i = 1; i < len; i++){
			dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
			//dp[i]的含义是i为右端点向左延伸存在的连续子串的最大和
			//如果第i+1个数值不要的话，那么应该从第i+2个数值开始重新记录连续子串
			//或者说，当前数值向左延伸无法使其构成的连续子串的和大于当前值则舍弃向左延伸的操作
			//参考文章：https://blog.csdn.net/lw_power/article/details/80892362
            result = Math.max(result,dp[i]);
		}
		//for(int i = 1; i < len; i++){
			//if(dp[i]>result)result=dp[i];
		//}
		return result;
	}
	public static void main(String args[]) {
		Solution solve = new Solution();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int result = solve.maxSubArray(nums);
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
