package qu_152;

public class Solution {
	public int maxProduct(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		int[][] dp = new int[len+1][len+1];
		int result=0;
		for(int i=1;i<=len;i++){
			dp[i][i]=nums[i-1];
			result = Math.max(result,nums[i-1]);
			for(int j=i+1;j<=len;j++){
				dp[i][j]=dp[i][j-1]*nums[j-1];
				if(dp[i][j]>result)result=dp[i][j];
			}
		}
		return result;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
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
