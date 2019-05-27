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
		//������ �����ݹ���Է����޳����ڵķ�֧
		Arrays.sort(A);
		//����i�� ��ÿ��i���л���
		for(int i = 1;i <= len / 2;i++){
			//ע������ s* i % len == 0���ж�
			if(s * i % len == 0 && nsum(A, s * i / len, i, 0))return true;
		}
		return false;
	}
	//A[start]��a[k]�������==target
	public boolean nsum(int[] A, int target, int k, int start){
		if(k==0)return target==0;//û���Ӵ������Ӵ���Ϊ0Ϊnsum�Ӵ��ָ�ɹ���
		//�Ż�
		if(A[start] > target / k)return false;
		for(int i = start;i < A.length - k + 1;i++){//��֤����k��Ԫ�أ��������һ��i�±�ΪA.length-(k-1)
			//�޳����ڷ�֧?����ͬ����ͬ��
			if(i > start && A[i] == A[i - 1])continue;
			//���ݷ�
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

