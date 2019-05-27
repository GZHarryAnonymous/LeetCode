package qu_198;
//reference:
//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
public class Solution {
	//����ѡ���ڵ��������ᾯ��
	public int rob(int[] nums) {
        return rob(nums,nums.length-1);
	}
	//dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1])
	private int rob(int[] nums,int i){
	    if(i<0)return 0;
	    //��ǰ��͵�벻͵����ѡ��
	    return Math.max(rob(nums,i-2)+nums[i],rob(nums,i-1));
    }
	public static void main(String args[]) {
		Solution s = new Solution();
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