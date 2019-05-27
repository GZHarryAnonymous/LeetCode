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
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/
