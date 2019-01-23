package qu_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int romanToInt(String s) {
		int len = s.length(), result = 0, a = 0, b = getNum(s.charAt(0));
		for (int i = 1; i < len; i++) {
			a = b;
			b = getNum(s.charAt(i));
			if (a < b) {
				result -= a;
			} else {
				result += a;
			}
		}
		return result + b;
	}

	private int getNum(char c) {
		switch (c) {
		case 'I':
			return 1;
		// break;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		// break;
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
