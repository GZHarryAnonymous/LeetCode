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
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/
