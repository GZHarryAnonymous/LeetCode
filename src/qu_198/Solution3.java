package qu_198;

import java.util.Arrays;

//reference:
//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
public class Solution3 {
	//����ѡ���ڵ��������ᾯ��
	int memo[];
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
        memo = new int[len+1];
        memo[0]=0;
        memo[1]=nums[0];
        for(int i=1;i<len;i++){
        	memo[i+1]=Math.max(memo[i-1]+nums[i],memo[i]);
		}
		return memo[len];
	}
	//dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1])
	public static void main(String args[]) {
		Solution3 s = new Solution3();
		int[] a = {2,1,1,2};
		int result=s.rob(a);
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