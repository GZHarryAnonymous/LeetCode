package qu_42;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
// https://leetcode.com/problems/trapping-rain-water/solution/
// ¶¯Ì¬¹æ»®
public class Solution2 {
	int trap(int[] height)
	{
		if(height == null)
			return 0;
		int len = height.length;
		if(len == 0)return 0;
		int ans = 0;
		int[] left_max = new int[len];
		int[] right_max = new int[len];
		left_max[0] = height[0];
		for (int i = 1; i < len; i++) {
			left_max[i] = Math.max(height[i], left_max[i - 1]);
		}
		right_max[len - 1] = height[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			right_max[i] = Math.max(height[i], right_max[i + 1]);
		}
		for (int i = 1; i < len - 1; i++) {
			ans += Math.min(left_max[i], right_max[i]) - height[i];
		}
		return ans;
	}
	public static void main(String args[]) {
		Solution2 s = new Solution2();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = s.trap(height);
		System.out.println(result);
	}
}

