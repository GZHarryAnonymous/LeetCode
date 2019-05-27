package qu_213;

public class Solution {
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		return rob(nums,0,len-1);
	}
	public int rob(int[] nums,int start,int end){
		if(end<start)return 0;
		if(start==end)return nums[start];
		if(end==nums.length-1){
			return Math.max((rob(nums,1,end-2)+nums[end]),rob(nums,0,end-1));
		}else{
			return Math.max((rob(nums,start,end-2)+nums[end]),rob(nums,start,end-1));
		}
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = {2,3,2};
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
