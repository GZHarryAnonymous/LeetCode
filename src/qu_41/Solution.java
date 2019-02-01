package qu_41;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
	public int firstMissingPositive(int[] nums) {
		if(nums.length==0)return 1;//nums Ϊ��
		Arrays.sort(nums);// ˫���Ŀ���
		int firstMiss = 1;
		for (int num : nums) {
			if (num < 0)
				continue;// ȷ������
			if (num > 0) {
				if (num > firstMiss)
					return firstMiss;
				if (num < firstMiss)
					continue;// �����ظ��������[1,1]
				firstMiss++;
			}
		}
		return nums[nums.length - 1] + 1;// [1,2,3]Ӧ�÷���4
	}
	public static void main(String args[]) {
		Solution s = new Solution();
		int[] nums = {1,1};
		int result= s.firstMissingPositive(nums);
		System.out.println(result);
	}
}
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/
