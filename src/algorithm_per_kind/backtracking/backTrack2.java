package algorithm_per_kind.backtracking;

//https://blog.csdn.net/sinat_27908213/article/details/80599460
public class backTrack2 {
	public static void main(String[] args){
			int[] num=new int[]{2,3,7,6};
			int target=9;
			find(num, target, "");
		}
	public static void find(int[] num, int target, String temp){
		if(issolution(temp,target)){
			System.out.println(temp);
			return;
		}
		for(int i=0;i<num.length;i++){
			if(num[i]!=-1){//如果取过这个数字了，就置为-1
				int k=num[i];
				num[i]=-1;
				find(num, target, temp+k);
				num[i]=k;
			}
		}
	}

	public static boolean issolution(String temp, int target){
			boolean result=false;
			int count=0;
			for(int i=0;i<temp.length();i++){
				count=count+Integer.valueOf(temp.charAt(i)+"");
			}
			if(count==target)
				result=true;
			return result;
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