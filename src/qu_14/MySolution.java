package qu_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		StringBuilder result = new StringBuilder();
		int i = 0;
		char cmp;
		while (true) {
			if (strs[0].length() > i) {
				cmp = strs[0].charAt(i);
			} else {
				return result.toString();
			}
			for (String str : strs) {
				if (str.length() <= i)
					return result.toString();
				char c = str.charAt(i);
				if (cmp != c) {
					return result.toString();
				}
			}
			result.append(cmp);
			i++;
		}

	}

	public static void main(String args[]) {
		MySolution s = new MySolution();
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
