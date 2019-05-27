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
			dp[0][i]=Math.min(nums[i],Math.min(dp[0][i-1]*nums[i],dp[1][i-1]*nums[i]));// 0,i������ 1,i��������
			dp[1][i]=Math.max(nums[i],Math.max(dp[0][i-1]*nums[i],dp[1][i-1]*nums[i]));// 0,i������ 1,i��������
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
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/
