package qu_343;

public class Solution1 {
	public int integerBreak(int n) {//n>=2 <=58
		switch(n){
			case 0:return 0;
			case 1:return 0;
			case 2:return 1;
			case 3:return 2;
			case 4:return 4;
			case 5:return 6;
			case 6:return 9;
			case 7:return 12;
			case 8:return 18;
		}
		int[] a={9,12,18};
		int i = 9,index = 0;
		for(;i<=n;i++){
			index=i%3;
			a[index]=a[index]*3;
		}
		return a[index];
	}
	public static void main(String args[]) {
		Solution1 s = new Solution1();
		int result=s.integerBreak(11);
		System.out.println(result);
	}
}

