package qu_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1, maxArea = 0;
		while (i != j) {
			int curArea;
			if (height[j] > height[i]) {
				curArea = (j - i) * height[i];
				i++;
			} else {
				curArea = (j - i) * height[j];
				j--;
			}
			if (curArea > maxArea)
				maxArea = curArea;
		}
		return maxArea;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * 相关说明： 基于LeetCode平台算法的一个刷题记录！ 已经共享至public repository，链接如下：
 * https://github.com/GZHarryAnonymous/LeetCode 欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 * 个人博客：https://gzharryanonymous.github.io/ 欢迎来访！当然，如果来访还打赏就更好啦！！！ 能力有限，希望有帮到你！
 **/
