package qu_213;

public class Solution3 {
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		int dp[][] = new int[len+1][len+1];
		for(int i=1;i<=len;i++){
			dp[i][i]=nums[i-1];
		}
		for(int i=1;i<=len;i++){
			for(int j=i+1;j<=len;j++){
				if(j==len&&i==1){
					dp[i][j]=Math.max(dp[2][j-2]+nums[j-1],dp[1][j-1]);
				}else{
					dp[i][j]=Math.max(dp[i][j-2]+nums[j-1],dp[i][j-1]);
				}
			}
		}
		return dp[1][len];
	}

	public static void main(String args[]) {
		Solution3 s = new Solution3();
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
