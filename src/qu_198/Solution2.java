package qu_198;

import java.util.Arrays;

//reference:
//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
public class Solution2 {
	//不能选相邻的两个，会警报
	int memo[];
	public int rob(int[] nums) {
        memo = new int[nums.length+1];
		Arrays.fill(memo,-1);
		return rob(nums,nums.length-1);
	}
	//dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1])
	private int rob(int[] nums,int i){
	    if(i<0)return 0;
	    //当前的偷与不偷两种选择
		if(memo[i]>=0)return memo[i];
	    int result = Math.max(rob(nums,i-2)+nums[i],rob(nums,i-1));
	    memo[i] = result;
	    return result;
    }
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[] a = {2,1,1,2};
		int result=s.rob(a);
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