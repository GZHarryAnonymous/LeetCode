package qu_15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList();
		for (int i = 0; i < nums.length; i++) {
			while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
				i++;
			} // avoid duplicates
			if (i == nums.length) {
				break;
			}
			int left = i + 1, right = nums.length - 1, target = -nums[i];
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum < target) {
					left++;
				} else if (sum > target) {
					right--;
				} else {
					result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					} // avoid duplicates
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					} // avoid duplicates
				}
			}
		}
		return result;
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
