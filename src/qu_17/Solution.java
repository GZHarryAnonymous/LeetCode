package qu_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	List<String> result = new ArrayList<String>();// ������������,�Ա�洢���ս����
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return result;
		String[] map = new String[10];
		map[2] = "abc";
		map[3] = "def";
		map[4] = "ghi";
		map[5] = "jkl";
		map[6] = "mno";
		map[7] = "pqrs";
		map[8] = "tuv";
		map[9] = "wxyz";
		recursiveMap(digits, 0, map, "");
		return result;
	}

	private void recursiveMap(String digits, int indexLength, String[] map, String updateValue) {// void
		if (indexLength == digits.length()) {// �ݹ����ֹ��
			result.add(updateValue);
			return;
		}
		String curAlphabet = map[digits.charAt(indexLength) - '0'];
		for (int i = 0; i < curAlphabet.length(); i++) {
			recursiveMap(digits, indexLength + 1, map, updateValue + curAlphabet.charAt(i));
		}

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
