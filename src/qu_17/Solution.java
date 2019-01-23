package qu_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	List<String> result = new ArrayList<String>();// 作用域整个类,以便存储最终结果。
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return result;
		String[] map = new String[10];
		map[2] = "abc";
		map[3] = "def";
		map[4] = "ghi";
		map[5] = "jkl";
		map[6] = "mno";
		map[7] = "pqrs";
		map[8] = "tuv";
		map[9] = "wxyz";
		recursiveMap(digits, 0, map, "");
		return result;
	}

	private void recursiveMap(String digits, int indexLength, String[] map, String updateValue) {// void
		if (indexLength == digits.length()) {// 递归的终止。
			result.add(updateValue);
			return;
		}
		String curAlphabet = map[digits.charAt(indexLength) - '0'];
		for (int i = 0; i < curAlphabet.length(); i++) {
			recursiveMap(digits, indexLength + 1, map, updateValue + curAlphabet.charAt(i));
		}

	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * 相关说明： 基于LeetCode平台算法的一个刷题记录！ 已经共享至public repository，链接如下：
 * https://github.com/GZHarryAnonymous/LeetCode
 * 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 * 个人博客：https://gzharryanonymous.github.io/ 欢迎来访！当然，如果来访还打赏就更好啦！！！ 能力有限，希望有帮到你！
 **/
