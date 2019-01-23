package qu_22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	List<String> result = new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
		generateNum(1, "(", n, 1);
		return result;
	}

	private void generateNum(int remain, String str, int n, int putNum) {
		if (str.length() == 2 * n) {
			result.add(str);
			return;
		}
		if (putNum < n) {
			generateNum(remain + 1, str + '(', n, putNum + 1);
			// System.out.println(remain+1+"num<n "+str+'1');
		}
		if (remain > 0) {
			generateNum(remain - 1, str + ')', n, putNum);
			// System.out.println(remain-1+"num>0 "+str+'0');
		}

	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int result = 0;
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
