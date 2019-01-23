package qu_12;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public String intToRoman(int num) {
		StringBuffer stack = new StringBuffer(49);
		if (num >= 1000) {
			int len = num / 1000;
			for (int i = 0; i < len; i++) {
				stack.append("M");
				num -= 1000;
			}
			// num-=1000*len;
		}
		if (num >= 500) {
			if (num < 900) {
				stack.append("D");
				num -= 500;
			} else {
				stack.append("CM");
				num -= 900;
			}
		}
		if (num >= 100) {
			if (num < 400) {
				int len = num / 100;
				for (int i = 0; i < len; i++) {
					stack.append("C");
					num -= 100;
				}
				// num-=len*100;
			} else {
				stack.append("CD");
				num -= 400;
			}
		}
		if (num >= 50) {
			if (num < 90) {
				stack.append("L");
				num -= 50;
			} else {
				stack.append("XC");
				num -= 90;
			}
		}
		if (num >= 10) {
			if (num < 40) {
				int len = num / 10;
				for (int i = 0; i < len; i++) {
					stack.append("X");
					num -= 10;
				}
			} else {
				stack.append("XL");
				num -= 40;
			}
		}
		if (num >= 5) {
			if (num < 9) {
				int len = num - 5;
				stack.append("V");
				for (int i = 0; i < len; i++) {
					stack.append("I");
					num -= 1;
				}
			} else {
				stack.append("IX");
				num -= 9;
			}
		} else if (num == 4) {
			stack.append("IV");
		} else {
			for (int i = 1; i <= num; i++) {
				stack.append("I");
			}
		}
		return stack.toString();
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
