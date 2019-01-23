package qu_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 4)
			return res;
		Arrays.sort(nums);
		if (nums[0] + nums[1] + nums[2] + nums[3] > target || nums[nums.length - 1] + nums[nums.length - 2]
				+ nums[nums.length - 3] + nums[nums.length - 4] < target)
			return res;
		for (int i = 0; i < nums.length - 3; i++) {
			while (i > 0 && nums[i] == nums[i - 1])
				i++;
			if (i >= nums.length - 3)
				break;
			for (int j = i + 1; j < nums.length - 2; j++) {
				while (j > 1 && j < nums.length - 2 && j - 1 != i && nums[j] == nums[j - 1])
					j++;
				if (j >= nums.length - 2)
					break;
				int tar = target - nums[i] - nums[j];
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					int num = nums[left] + nums[right];

					if (num == tar) {

						List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]);
						// if (!res.contains(tmp))
						res.add(tmp);

					} else if (num < tar) {
						left++;
					} else {
						right--;
					}
					while (left < right && left > 1 && left - 1 != j && nums[left] == nums[left - 1])
						left++;
					while (left < right && right < nums.length - 1 && nums[right] == nums[right + 1])
						right--;
				}

			}
		}
		return res;
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
