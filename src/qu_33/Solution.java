package qu_33;

public class Solution {
	public int search(int[] nums, int target) {
		int len = nums.length;
		if(len==0)return -1;
		return searchBinary(nums, target, 0, len - 1, nums[len - 1]);
	}

	public int searchBinary(int[] nums, int target, int left, int right, int value) {
		int middle = (left + right) / 2;
		if (nums[middle] == target) {
			return middle;
		} else if (left == right) {
			return -1;
		}
		if (nums[middle] > value) {
			if (target < nums[middle]) {
				if (target > value) {
					return searchBinary(nums, target, 0, middle, value);
				} else {
					return searchBinary(nums, target, middle + 1, right, value);
				}
			} else {
				return searchBinary(nums, target, middle + 1, right, value);
			}
		} else {
			if (target < nums[middle]) {
				return searchBinary(nums, target, 0, middle, value);
			} else {
				if (target > value) {
					return searchBinary(nums, target, 0, middle, value);
				} else {
					return searchBinary(nums, target, middle + 1, right, value);
				}

			}
		}
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 3;
		int result = s.search(nums, target);
		System.out.println(result);
	}
}
