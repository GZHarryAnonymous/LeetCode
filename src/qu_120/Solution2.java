package qu_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
	int a[];
	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		//System.out.println(len);
		if(len==0)return 0;
		if(len==1)return triangle.get(0).get(0);
		a = new int[len];
		a[0] = triangle.get(0).get(0);
		int result = Integer.MAX_VALUE;
		for(int i=1;i<len;i++){
			print_a();
			for(int j=i;j>=0;j--){
				if(j==0){
					a[j]=a[0]+triangle.get(i).get(j);
				}else if(j==i){
					a[j]=a[j-1]+triangle.get(i).get(j);
				}else{
					a[j]=Math.min(a[j-1],a[j])+triangle.get(i).get(j);
				}
				if(i==len-1)result = Math.min(a[j],result);
			}
		}
		print_a();
		//Arrays.sort(a);
		//return a[0];
		return result;
	}
	public void print_a(){
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String args[]) {
		Solution2 s = new Solution2();
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
