package qu_213;

public class Solution4 {
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		int dp[][] = new int[2][len+1];
		dp[0][0]=0;dp[0][1]=0;//i=0��ʾ��һ����Ҫ
		dp[1][0]=0;dp[1][1]=nums[0];//i=1��ʾ��һ��Ҫ
		for(int i=2;i<=len;i++) {
			dp[0][i] = Math.max(dp[0][i-2] + nums[i-1], dp[0][i-1]);
			dp[1][i] = Math.max(dp[1][i-2] + nums[i-1], dp[1][i-1]);
		}
		return Math.max(dp[0][len],dp[1][len-1]);//��һ����Ҫ�����һ����Ҫ��һ����
	}

	public static void main(String args[]) {
		Solution4 s = new Solution4();
		int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int result=s.rob(nums);
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
