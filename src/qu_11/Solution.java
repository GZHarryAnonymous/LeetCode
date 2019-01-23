package qu_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1, maxArea = 0;
		while (i != j) {
			int curArea;
			if (height[j] > height[i]) {
				curArea = (j - i) * height[i];
				i++;
			} else {
				curArea = (j - i) * height[j];
				j--;
			}
			if (curArea > maxArea)
				maxArea = curArea;
		}
		return maxArea;
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * ���˵���� ����LeetCodeƽ̨�㷨��һ��ˢ���¼�� �Ѿ�������public repository���������£�
 * https://github.com/GZHarryAnonymous/LeetCode ��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 * ���˲��ͣ�https://gzharryanonymous.github.io/ ��ӭ���ã���Ȼ��������û����;͸����������� �������ޣ�ϣ���аﵽ�㣡
 **/
