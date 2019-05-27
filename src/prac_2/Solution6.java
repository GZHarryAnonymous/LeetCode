package prac_2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class A{
	int get_next_index(int[][] relation,int index,int n){
		for(int i=1;i<=n;i++){
			if(relation[index][i]==1){
				relation[index][i]=0;
				relation[i][index]=0;
				return i;
			}
		}
		return -1;
	}
	int get_length(int[][] relation,int index,int n){
		int len=1,next_index=get_next_index(relation,index,n);
		while(next_index!=-1){
			next_index = get_next_index(relation,next_index,n);
			len++;
		}
		return len;
	}
	int get_deep(int[][] relation,int max_degree_index,int n){
		boolean tag =false;
		int len = 0;
		for(int i=1;i<=n;i++){
			if(relation[max_degree_index][i]==1){
				tag = true;
				relation[max_degree_index][i]=0;
				relation[i][max_degree_index]=0;
				int tmp=get_length(relation,i,n)+1;
				if(tmp>len)len=tmp;
			}
		}
		if(!tag)return 1;
		return len;
	}
}
class Solution6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] relation = new int[n + 1][n + 1];
		int[] count_degree = new int[n + 1];
		int max_degree=0,max_degree_index =0;
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			count_degree[a]++;
			if(count_degree[a]>max_degree){
				max_degree = count_degree[a];
				max_degree_index = a;
			}
			int b = sc.nextInt();
			count_degree[b]++;
			if(count_degree[b]>max_degree){
				max_degree = count_degree[b];
				max_degree_index = b;
			}
			relation[a][b] = 1;
			relation[b][a] = 1;
		}
		//System.out.println("max_degree"+max_degree);
		//System.out.println("max_degree_index"+max_degree_index);
		A a = new A();
		int result = a.get_deep(relation,max_degree_index,n);
		System.out.println(result);
	}
}
