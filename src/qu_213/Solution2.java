package qu_213;

public class Solution2 {
	int dp[][];
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		dp = new int[len][len];
		return rob(nums,0,len-1);
	}
	public int rob(int[] nums,int start,int end){
		if(end<start)return 0;
		if(start==end)return nums[start];
		if(dp[start][end]>0)return dp[start][end];
		if(end==nums.length-1){
			dp[start][end] = Math.max((rob(nums,1,end-2)+nums[end]),rob(nums,0,end-1));
		}else{
			dp[start][end] = Math.max((rob(nums,start,end-2)+nums[end]),rob(nums,start,end-1));
		}
		return dp[start][end];
	}
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[] nums = {2,7,9,3,1};
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
