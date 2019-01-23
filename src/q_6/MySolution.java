package q_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {
	public String convert(String s, int numRows) {
		int length = s.length();
		if (s.equals("") || length == 0)
			return "";
		if (length == 1 || numRows == 1 || length <= numRows)
			return s;
		int curIndex = 0;
		StringBuilder result = new StringBuilder("");
		int colMax = 0;
		while (((colMax - 1) / (numRows - 1) + 1) * (numRows - 1) + colMax < length) {
			colMax++;
		}
		for (int line = 1; line <= numRows; line++) {
			int column = 1;
			do {
				int tmp = ((column - 1) / (numRows - 1) + 1) * (numRows - 1) + column - numRows + line;
				if (tmp > length || curIndex > length || column > colMax)
					break;
				int tag = (column - 1) % (numRows - 1);
				if (tag == 0) {
					curIndex = (2 * numRows - 2) * ((column - 1) / (numRows - 1)) + line;
					if (line != numRows) {
						column += (numRows - line);// control the step.
					} else {
						column += (numRows - 1);
					}
				} else {
					curIndex = (2 * numRows - 2) * ((column - 1) / (numRows - 1)) + numRows + tag;
					column += (line - 1);// control the step.
				}

				result.append(s.charAt(curIndex - 1));
			} while (true);
		}
		return result.toString();
	}

	public static void main(String args[]) {
		MySolution s = new MySolution();
		int result = 0;
		System.out.println(result);
	}
}
/*
 * ���˵���� ����LeetCodeƽ̨�㷨��һ��ˢ���¼�� �Ѿ�������public repository���������£�
 * https://github.com/GZHarryAnonymous/LeetCode ��ӭ������fork��push������ش��󡢽���������⣡(�����˸�����Ŷ��)
 * ���˲��ͣ�https://gzharryanonymous.github.io/ ��ӭ���ã���Ȼ��������û����;͸����������� �������ޣ�ϣ���аﵽ�㣡
 **/
