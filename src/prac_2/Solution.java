package prac_2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void print(String[] s){
		for(String i:s){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static int getBoundary(String s){
		int len = s.length();
		for(int i=len-1;i>=0;i--){
			if(s.charAt(i) == '+'){
				return i;
			}
		}
		return 0;
	}
	public static String getKey(String s,int boundary){
		return s.substring(0,boundary);
	}
	public static int getIndex(String s,int boundary){
		return Integer.parseInt(s.substring(boundary+1));
	}
	public static void main(String[] args) {
		//System.out.println("start");
		Map<String,Integer> map = new HashMap<String,Integer>();
		Scanner sc = new Scanner(System.in);
		int path_num = sc.nextInt();
		int[] result = new int[path_num];
		for(int i=0;i<path_num;i++){
			String s = sc.next();
			String[] c = s.split("/");
			//System.out.println(c.length);
			//print(c);
			int tmp=0;
			String key=null;
			for(int j=1;j<c.length;j++){
				key = c[j]+"+"+j;
				//System.out.println(tmp);
				if(j==1){
					tmp=1;
				}else if(j<c.length-1){
					if(!map.containsKey(key)){
						map.put(key,1);
						tmp=tmp*10+1;
					}else{
						int boundary = getBoundary(key);
						//String real_key = getKey(key,boundary);
						int index = getIndex(key,boundary);
						if(index==j){
							int time = map.get(key);
							tmp=tmp*10+(time+1);
							map.put(key,time+1);
						}else{
							tmp=tmp*10+1;
							//value相同但是下标位置不同的情况
							//key值相同会自动覆盖
							//所以以c[j]与j作为唯一标识
							map.put(c[j]+"+"+j,1);
						}
					}
				}else{
					tmp=tmp*10+1;
				}
			}
			result[i]=tmp;
		}
		for(int i:result){
			System.out.print(i+" ");
		}
		}
	}
//71.3->100 改进成功！
//3 /a/b/c/d/e /a/b/e /a/c/d/d/e
//11111 121 11121