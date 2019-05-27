package qu_198;

import java.util.Arrays;

//reference:
//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
public class Solution2 {
	//����ѡ���ڵ��������ᾯ��
	int memo[];
	public int rob(int[] nums) {
        memo = new int[nums.length+1];
		Arrays.fill(memo,-1);
		return rob(nums,nums.length-1);
	}
	//dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1])
	private int rob(int[] nums,int i){
	    if(i<0)return 0;
	    //��ǰ��͵�벻͵����ѡ��
		if(memo[i]>=0)return memo[i];
	    int result = Math.max(rob(nums,i-2)+nums[i],rob(nums,i-1));
	    memo[i] = result;
	    return result;
    }
	public static void main(String args[]) {
		Solution2 s = new Solution2();
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