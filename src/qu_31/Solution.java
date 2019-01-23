package qu_31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
	public void nextPermutation(int[] nums) {
		int len = nums.length;
		if (len == 1)
			return;
		if (len == 2) {
			swap(nums, 0, 1);
			return;
		}
		int i;
		for (i = len - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {// 第一个正序（小大）出现的地方！
				break;// nums[i]<nums[i+1];
			}
		}
		if (i == -1) {// 如果没有正序出现，完全从大到小，则从小到大重排序。
			// Arrays.sort(nums);
			reverse(nums, 0, len - 1);
			return;
		}
		if (len - i == 2) {// 最后两个是正序的关系，则交换之。
			swap(nums, i, i + 1);
			return;
		} // 第一个正序是后两位，则直接交换。如：123-》132，213-》231
		// 第一个正序非后两位，则交换nums[i]与i之后的min(nums[i+])且大于nums[i]
		// 从nums[len-1]开始算起。若存在则使得i之后尾串正序排列。
		// 若不存在，则swap(i,i+1),且使得i+1之后正序排列。
		// 如：14532-》15432-》15423
		// 15432-》51234
		int j = len - 1;
		while (j > i) {// 找到i之后的那个nums[i]大的那个最小的j
			if (nums[j] > nums[i])
				break;
			j--;
		}
		swap(nums, i, j);
		// Arrays.sort(nums,i+1,len);//i之后都应该有序！sort底层是快排。
		reverse(nums, i + 1, len - 1);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = { 1, 3, 2 };
		solution.nextPermutation(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}