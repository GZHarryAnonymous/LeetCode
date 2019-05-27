package qu_122;

public class Solution {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if(len<=1)return 0;
		int profit = 0;
		for(int i=1;i<len;i++){
			if(prices[i]>prices[i-1]){
				profit+=(prices[i]-prices[i-1]);
			}
		}
		return profit;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] prices = {7,1,5,3,6,4};
		int result=s.maxProfit(prices);
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
