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
public class Solution2 {
	public boolean isMatch(String s, String p) {
		int s_len = s.length(),p_len=p.length();
		boolean[][] dp = new boolean[s_len+1][p_len+1];
		// �߽縳ֵ��
		// s="" && p=""
		dp[0][0]=true;
		// p=""
		for(int i=1;i<=s_len;i++){
			dp[i][0]=false;
		}
		// s=""
		for(int j=1;j<=p_len;j++){
			dp[0][j]=dp[0][j-1]&&p.charAt(j-1)=='*';
		}
		// sΪ�У�pΪ�У���һ�·�����pӦ�������ѭ����
		for(int j=1;j<=p_len;j++){
			for(int i=1;i<=s_len;i++){
				// ״̬ת�Ʒ��̡�
				if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
					dp[i][j]=dp[i-1][j-1];
				}else if(p.charAt(j-1)=='*'){
					dp[i][j]=dp[i-1][j]||dp[i][j-1];
				}
			}
		}
		return dp[s_len][p_len];
	}
	public static void main(String args[]) {
		Solution2 solve = new Solution2();
		String s = "aa";
		String p = "*";
		boolean result=solve.isMatch(s,p);
		System.out.println(result);
	}
}

