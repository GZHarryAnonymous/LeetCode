package qu_44;

// �� ƥ�����ⵥ���ַ���Сд��ĸ��  * ƥ��0����������ַ�������
// ���� ԭ�ַ���p   ��    ģʽ�ַ���s���Ƚ���� false or true

/**
 * ��̬�滮��
 * �Ե����ϻ����Զ����¡�
 * ����¼ģʽ���Զ�����˼·��
 * 	if p[j]=='?' or p[j] == s[i]  then dp[i][j]=dp[i-1][j-1].
 * 	if p[j]=='*' then dp[i][j]=dp[i][j-1] or dp[i-1][j]
 */
public class Solution3 {
	public boolean isMatch(String s, String p) {
		// �ַ���ת�ַ����顣
		char[] s_char = s.toCharArray();
		char[] p_char = p.toCharArray();
		int i = 0;
		int j = 0;
		int star_start = -1;
		int s_k = 0; // ��¼���һ��ƥ���λ��  + 1

		while (i < s.length()) {
			if (j < p.length() && (s_char[i] == p_char[j] || p_char[j] == '?')) {
				++i;
				++j;
				continue;
			}

			if (j < p.length() && p_char[j] == '*') {
				star_start = j++;
				s_k = i;
				continue;
			}

			// ���ʧ���ˣ����ݵ� k + 1������ * �ٶ�����һ���ַ���
			if (star_start != -1) {
				i = ++s_k;// �� * �ٶ�����һ���ַ�
				j = star_start + 1;// Ȼ�� * ����һ����ʼ�Ƚ�
				continue;
			}
			return false;
		}

		while (j < p.length() && p_char[j] == '*') ++j;

		return j == p.length();
	}
	public static void main(String args[]) {
		Solution3 solve = new Solution3();
		String s = "aa";
		String p = "*";
		boolean result=solve.isMatch(s,p);
		System.out.println(result);
	}
}

