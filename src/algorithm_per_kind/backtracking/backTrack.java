package algorithm_per_kind.backtracking;

import java.util.ArrayList;

//https://blog.csdn.net/sinat_27908213/article/details/80599460
public class backTrack {
	public static void main(String[] args) {
		int n = 3;
		int leftnum = n, rightnum = n;//左括号和右括号都各有n个
		ArrayList<String> results = new ArrayList<String>();//用于存放解空间
		parentheses("", results, leftnum, rightnum);
		for (String s : results)
			System.out.println(s);
	}

	public static void parentheses(String sublist, ArrayList<String> results, int leftnum, int rightnum) {
		if (leftnum == 0 && rightnum == 0)//结束
			results.add(sublist);
		if (leftnum > 0)
			parentheses(sublist + "(", results, leftnum - 1, rightnum);
		if (rightnum > leftnum)//选择和条件。对于不同的if顺序，输出的结果顺序是不一样的，但是构成一样的解空间
			parentheses(sublist + ")", results, leftnum, rightnum - 1);

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