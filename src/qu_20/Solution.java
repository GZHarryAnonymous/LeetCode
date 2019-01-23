package qu_20;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
public class Solution {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		for (; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (tmp == '(' || tmp == '{' || tmp == '[') {
				stack.push(tmp);
			} else {
				if (!stack.isEmpty() && tmp == map.get(stack.pop())) {
					continue;
				}
				break;
			}
		}
		return (stack.isEmpty() && i == s.length());
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
