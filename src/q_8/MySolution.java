package q_8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {
	public int myAtoi(String str) {
		int length = str.length();
		if (str.equals("") || length == 0)
			return 0;
		int i = 0, result = 0;
		while (str.charAt(i) == ' ') {
			i++;
			if (i >= length)
				return 0;
		}

		// Character a = str.charAt(i);

		// int check=Integer.parseInt(str.substring(i,i+1));
		// if(check>9||check<0){return 0;}
		boolean isMinus = false, isAdd = false;
		if (str.charAt(i) == '-') {

			isMinus = true;
			i++;

		}
		if (i >= length)
			return 0;
		if (str.charAt(i) == '+') {

			isAdd = true;
			i++;
		}
		if (i >= length)
			return 0;
		if (str.charAt(i) == '-') {
			if (isMinus == true)
				return result;
			isMinus = true;
			i++;
		}
		if (i >= length)
			return 0;
		if (str.charAt(i) == '+') {
			if (isAdd == true)
				return result;
			isAdd = true;
			i++;
		}
		// if(i>=length)return 0;
		if (isAdd && isMinus)
			return result;
		for (; i < length; i++) {
			int check = str.charAt(i) - '0';
			if (check > 9 || check < 0) {
				if (isMinus)
					return result * (-1);
				else
					return result;
			}
			if (!(isMinus) && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && check > 7))) {

				return Integer.MAX_VALUE;
			}
			if (isMinus && (result * (-1) < Integer.MIN_VALUE / 10
					|| (result * (-1) == Integer.MIN_VALUE / 10 && check > 8))) {

				return Integer.MIN_VALUE;
			}

			result = result * 10 + check;
			// System.out.println(result);
			// if(result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
			// if(result<Integer.MIN_VALUE)return Integer.MIN_VALUE;
		}
		if (isMinus)
			return result * (-1);
		else
			return result;
	}

	public static void main(String args[]) {
		MySolution s = new MySolution();
		int result = 0;
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
