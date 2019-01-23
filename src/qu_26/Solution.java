package qu_26;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return len;
		int index = 0;
		for (int i = 1; i < len; i++) {
			if (nums[i] != nums[index]) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int result=0;
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
