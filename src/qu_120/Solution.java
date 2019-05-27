package qu_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	int a[][];
	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		//System.out.println(len);
		if(len==0)return 0;
		a = new int[len][len];//longest_len = len
		for(int j=0;j<len;j++){
			cal(triangle,len-1,j);
		}
		Arrays.sort(a[len-1]);
		return a[len-1][0];
	}
	public int cal(List<List<Integer>> triangle,int i,int j){
		if(a[i][j]>0)return a[i][j];
		if(i==0){a[0][0]=triangle.get(0).get(0);return a[0][0];}
		if(j==0){a[i][j]=cal(triangle,i-1,0)+triangle.get(i).get(j);return a[i][j];}
		if(i==j){a[i][j]=triangle.get(i).get(j)+cal(triangle,i-1,j-1);return a[i][j];}
		a[i][j]=Math.min(cal(triangle,i-1,j-1),cal(triangle,i-1,j))+triangle.get(i).get(j);
		return a[i][j];
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		List<Integer> b = new ArrayList<Integer>();
		b.add(3);
		b.add(4);
		List<Integer> c = new ArrayList<Integer>();
		c.add(6);
		c.add(5);
		c.add(7);
		List<Integer> d = new ArrayList<Integer>();
		d.add(4);
		d.add(1);
		d.add(8);
		d.add(3);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		int result=s.minimumTotal(list);
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
