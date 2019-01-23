package q_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {
	public int reverse(int x) {
		int popNum = 0, rev = 0;
		while (x != 0) {
			popNum = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && popNum > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && popNum < -8))
				return 0;
			rev = rev * 10 + popNum;
		}

		return rev;
	}

	public static void main(String args[]) {
		MySolution s = new MySolution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * 相关说明： 基于LeetCode平台算法的一个刷题记录！ 已经共享至public repository，链接如下：
 * https://github.com/GZHarryAnonymous/LeetCode 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 * 个人博客：https://gzharryanonymous.github.io/ 欢迎来访！当然，如果来访还打赏就更好啦！！！ 能力有限，希望有帮到你！
 **/
