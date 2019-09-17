package qu_376;
// [1,7,4,9,2,5]
// -1,1,-1,1,-1
// 6
public class Solution {
	public int wiggleMaxLength(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return 1;
		int count=1;
		boolean isPositive=false;
		boolean firstChanged=true;
		int[] dp = new int[len];
		for(int i=1;i<len;i++){
			dp[i-1] = nums[i]-nums[i-1];
			if(dp[i-1]==0){
				continue;
			}
			if(firstChanged){
				if(dp[i-1]>0)isPositive=true;
				else isPositive=false;
				count++;
				firstChanged=false;
				continue;
			}else if(((dp[i-1]>0&&!isPositive)||(dp[i-1]<0&&isPositive))){
				isPositive=!isPositive;
				count++;
			}
		}
		return count;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = {1,7,4,9,2,5};
		int result=s.wiggleMaxLength(nums);
		System.out.println(result);

		int[] nums1 = {1,17,5,10,13,15,10,5,16,8};
		int result1=s.wiggleMaxLength(nums1);
		System.out.println(result1);

		int[] nums2 = {3,3,3,2,5};
		int result2=s.wiggleMaxLength(nums2);
		System.out.println(result2);

		int[] nums3 = {1,2,3,4,5,6,7,8,9};
		int result3=s.wiggleMaxLength(nums3);
		System.out.println(result3);
	}
}

