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
/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/
