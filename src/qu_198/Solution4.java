package qu_198;

//reference:
//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
public class Solution4 {
	//����ѡ���ڵ��������ᾯ��
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
        int pre1=0,pre2=nums[0];
        for(int i=1;i<len;i++){
        	int tmp=pre2;
        	pre2=Math.max(pre1+nums[i],pre2);
        	pre1=tmp;
		}
		return pre2;
	}
	//dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1])
	public static void main(String args[]) {
		Solution4 s = new Solution4();
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