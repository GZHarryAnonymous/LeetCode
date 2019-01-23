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
			if (nums[i] < nums[i + 1]) {// ��һ������С�󣩳��ֵĵط���
				break;// nums[i]<nums[i+1];
			}
		}
		if (i == -1) {// ���û��������֣���ȫ�Ӵ�С�����С����������
			// Arrays.sort(nums);
			reverse(nums, 0, len - 1);
			return;
		}
		if (len - i == 2) {// �������������Ĺ�ϵ���򽻻�֮��
			swap(nums, i, i + 1);
			return;
		} // ��һ�������Ǻ���λ����ֱ�ӽ������磺123-��132��213-��231
		// ��һ������Ǻ���λ���򽻻�nums[i]��i֮���min(nums[i+])�Ҵ���nums[i]
		// ��nums[len-1]��ʼ������������ʹ��i֮��β���������С�
		// �������ڣ���swap(i,i+1),��ʹ��i+1֮���������С�
		// �磺14532-��15432-��15423
		// 15432-��51234
		int j = len - 1;
		while (j > i) {// �ҵ�i֮����Ǹ�nums[i]����Ǹ���С��j
			if (nums[j] > nums[i])
				break;
			j--;
		}
		swap(nums, i, j);
		// Arrays.sort(nums,i+1,len);//i֮��Ӧ������sort�ײ��ǿ��š�
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