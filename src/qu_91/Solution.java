package qu_91;

public class Solution {
	public int numDecodings(String s) {
		int len = s.length();
		if(len<1)return 0;
		int[] a = new int[len];
		for(int i=0;i<len;i++){
			a[i] = s.charAt(i)-'0';
			if(i>0&&a[i]==0&&(a[i-1]==0||a[i-1]>2))return 0;
		}
		if(a[0]==0)return 0;
		return numCal(a,len-1);
	}
	public int numCal(int[] a,int index){
		if(index==0&&a[0]==0)return 0;
		if(index<=0)return 1;
		if(a[index]==0)return numCal(a,index-2);
		if(a[index-1]==0)return numCal(a,index-3);
		if(a[index-1]*10+a[index]<=26)return numCal(a,index-1)+numCal(a,index-2);
		return numCal(a,index-1);
	}
	public static void main(String[] args){
		Solution solve = new Solution();
		System.out.println(solve.numDecodings("230"));
	}
}
