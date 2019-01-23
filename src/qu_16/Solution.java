package qu_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length, delt = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			int left = i + 1, right = len - 1;
			while (left < right) {
				int tmp = nums[left] + nums[right] + nums[i];
				if (tmp < target) {
					left++;
				} else if (tmp > target) {
					right--;
				} else {
					return tmp;
				}
				if (Math.abs(target - tmp) < Math.abs(delt))
					delt = target - tmp;
			}
		}
		return target - delt;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * ���˵���� ����LeetCodeƽ̨�㷨��һ��ˢ���¼�� �Ѿ�������public repository���������£�
 * https://github.com/GZHarryAnonymous/LeetCode
 * ��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 * ���˲��ͣ�https://gzharryanonymous.github.io/ ��ӭ���ã���Ȼ��������û����;͸����������� �������ޣ�ϣ���аﵽ�㣡
 **/
