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
 * ���˵���� ����LeetCodeƽ̨�㷨��һ��ˢ���¼�� �Ѿ�������public repository���������£�
 * https://github.com/GZHarryAnonymous/LeetCode
 * ��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 * ���˲��ͣ�https://gzharryanonymous.github.io/ ��ӭ���ã���Ȼ��������û����;͸����������� �������ޣ�ϣ���аﵽ�㣡
 **/
