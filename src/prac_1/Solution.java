package prac_1;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
//805
//totalSum/n = Asum/k = Bsum/(n-k), where k = A.size() and 1 <= k <= n/2;
//Asum = totalSum*k/n, which is an integer. So we have totalSum*k%n == 0;
public class Solution {
	public boolean splitArraySameAverage(int[] A) {
		int len = A.length;
		if(len == 1)return false;
		int s = 0;
		for(int i : A)s+=i;
		//先排序， 后续递归可以方便剔除多于的分支
		Arrays.sort(A);
		//迭代i， 对每个i进行回溯
		for(int i = 1;i <= len / 2;i++){
			//注意这里 s* i % len == 0的判断
			if(s * i % len == 0 && nsum(A, s * i / len, i, 0))return true;
		}
		return false;
	}
	//A[start]到a[k]连加求和==target
	public boolean nsum(int[] A, int target, int k, int start){
		if(k==0)return target==0;//没有子串，则子串和为0为nsum子串分割成功。
		//优化
		if(A[start] > target / k)return false;
		for(int i = start;i < A.length - k + 1;i++){//保证构成k个元素，所以最后一个i下标为A.length-(k-1)
			//剔除多于分支?不相同？相同？
			if(i > start && A[i] == A[i - 1])continue;
			//回溯法
			if(nsum(A, target - A[i], k - 1, i + 1)) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = {1,2,3,4,5};
		System.out.println(s.splitArraySameAverage(a));
				//char a = '0';
				//System.out.println((int)a);
				//Scanner in = new Scanner(System.in);
				//int n = in.nextInt();
				//String s = in.next();
		}
	}

