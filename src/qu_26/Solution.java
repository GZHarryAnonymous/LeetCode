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
/*���˵����
 *����LeetCodeƽ̨�㷨��һ��ˢ���¼��
 *�Ѿ�������public repository���������£�
 *https://github.com/GZHarryAnonymous/LeetCode
 *��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 *���˲��ͣ�https://gzharryanonymous.github.io/
 *��ӭ���ã���Ȼ��������û����;͸�����������
 *�������ޣ�ϣ���аﵽ�㣡
 **/
