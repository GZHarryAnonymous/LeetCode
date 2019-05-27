package qu_303;
public class NumArray {
	private int[] dp;
	public NumArray(int[] nums) {
		int len=nums.length;
		dp = new int[len];
		for(int i=0;i<len;i++){
			if(i==0){
				dp[i]=nums[i];
			}else{
				dp[i]=dp[i-1]+nums[i];
			}
		}
	}

    public int sumRange(int i, int j) {
        if(i==0)return dp[j];
        return this.dp[j]-this.dp[i-1];
    }
	public static void main(String args[]) {
		int nums[] = {-2, 0, 3, -5, 2, -1};
		NumArray s = new NumArray(nums);
		int result=s.sumRange(1,2);
		System.out.println(result);
	}
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/