package qu_121;

public class Solution {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if(len==0||len==1)return 0;
		int min=prices[0],max_profites=0;
		for(int i=1;i<len;i++){
			if(prices[i]<min)min=prices[i];
			int tmp=prices[i]-min;
			if(tmp>max_profites)max_profites=tmp;
		}
		return max_profites;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] a = {7,1,5,3,6,4};
		int result=s.maxProfit(a);
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
