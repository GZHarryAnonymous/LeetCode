package qu_322;

import java.util.Arrays;
import java.util.Comparator;

class myComparator implements Comparator<Integer> {
	public int compare(Integer a,Integer b){
		//if(a>b)return -1;
		//else if(a<b) return 1;
		//return 0;
        return b-a;
	}
}
public class Solution {

	public int coinChange(int[] coins, int amount) {
		int len = coins.length;
		if(len==0)return -1;
		if(len==1&&amount%coins[0]==0)return amount/coins[0];
		//myComparator big_to_small = new myComparator();
        Arrays.sort(coins);
		int[] dp = new int[amount+1];
		for(int i=0;i<len;i++){
		    int num = 0,remainder = amount;
			while(remainder>=coins[i]){
				remainder-=coins[i];
				num++;
				dp[amount-remainder] = num;
			}
		}
		//int result = backTrackCoinKind(coins,dp,amount,Integer.MAX_VALUE);
		int result =0;
        return result;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] coins = {186,419,83,408};
		int result=s.coinChange(coins,6249);
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