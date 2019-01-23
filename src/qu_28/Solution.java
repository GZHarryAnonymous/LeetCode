package qu_28;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int strStr(String haystack, String needle) {
		int B_len = needle.length();
		if (B_len == 0)
			return 0;
		int A_len = haystack.length();
		if (A_len < B_len)
			return -1;
		for (int i = 0; i <= A_len - B_len; i++) {
			if (pan(haystack, needle, i, B_len))
				return i;
		}
		return -1;
	}
	private boolean pan(String A, String B, int start, int B_len) {
		// if(A.charAt(start+B_len-1)!=B.charAt(B_len-1))return false;
		for (int i = 0; i < B_len; i++) {
			if (A.charAt(start + i) != B.charAt(i))
				return false;
		}
		return true;
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
