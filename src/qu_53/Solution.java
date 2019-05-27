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
			//dp[i]�ĺ�����iΪ�Ҷ˵�����������ڵ������Ӵ�������
			//�����i+1����ֵ��Ҫ�Ļ�����ôӦ�ôӵ�i+2����ֵ��ʼ���¼�¼�����Ӵ�
			//����˵����ǰ��ֵ���������޷�ʹ�乹�ɵ������Ӵ��ĺʹ��ڵ�ǰֵ��������������Ĳ���
			//�ο����£�https://blog.csdn.net/lw_power/article/details/80892362
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
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/
