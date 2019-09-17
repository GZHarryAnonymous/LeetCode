package qu_309;

public class Solution {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if(len<2)return 0;
		int[][] profits = new int[len][2];//profits[i][0] buy_max_profits
		//profits[i][1] buy_min_profits
		profits[0][1]=0;
		profits[0][0]=-prices[0];
		for(int i=1;i<len;i++){
			profits[i][1]=Math.max(profits[i-1][1],profits[i-1][0]+prices[i]);
			profits[i][0]=Math.max(profits[i-1][0],(i>2?profits[i-2][1]:0)-prices[i]);
		}
		return profits[len-1][1];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] a = {1,2,3,0,2};
		int result=s.maxProfit(a);
		System.out.println(result);
	}
}

