package qu_22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	List<String> result = new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
		generateNum(1, "(", n, 1);
		return result;
	}

	private void generateNum(int remain, String str, int n, int putNum) {
		if (str.length() == 2 * n) {
			result.add(str);
			return;
		}
		if (putNum < n) {
			generateNum(remain + 1, str + '(', n, putNum + 1);
			// System.out.println(remain+1+"num<n "+str+'1');
		}
		if (remain > 0) {
			generateNum(remain - 1, str + ')', n, putNum);
			// System.out.println(remain-1+"num>0 "+str+'0');
		}

	}

	public static void main(String args[]) {
		Solution s = new Solution();
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
