package qu_338;

public class Solution {
	public int[] countBits(int num) {
		int[] dp=new int[num+1];
		for(int i=1;i<=num;i++){
			dp[i]=dp[i&(i-1)]+1;//i&(i-1) can be used to calculate the number of 1's bit.
		}
		return dp;
	}
	//using i&(i-1) to calculate the number of 1's bit
	public int countOneBit(int num){
		int count=0;
		while(num>0){
			num&=(num-1);
			count++;
		}
		return count;//when num=2^n,n=0,1,2,3,4,,,, the count is 1.
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int n=16;
		System.out.println(s.countOneBit(n));
		int[] result=s.countBits(n);
		for(int i=0;i<=n;i++){
			System.out.print(result[i]);
		}
	}
}

