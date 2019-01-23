package qu_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int romanToInt(String s) {
		int len = s.length(), result = 0, a = 0, b = getNum(s.charAt(0));
		for (int i = 1; i < len; i++) {
			a = b;
			b = getNum(s.charAt(i));
			if (a < b) {
				result -= a;
			} else {
				result += a;
			}
		}
		return result + b;
	}

	private int getNum(char c) {
		switch (c) {
		case 'I':
			return 1;
		// break;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		// break;
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
