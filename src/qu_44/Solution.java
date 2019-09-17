package qu_44;

import java.util.Arrays;
import java.util.Scanner;

// �� ƥ�����ⵥ���ַ���Сд��ĸ��  * ƥ��0����������ַ�������
// ���� ԭ�ַ���p   ��    ģʽ�ַ���s���Ƚ���� false or true
/**
 * ��̬�滮��
 * �Ե����ϻ����Զ����¡�
 * ����¼ģʽ���Զ�����˼·��
 * 	if p[j]=='?' or p[j] == s[i]  then dp[i][j]=dp[i-1][j-1].
 * 	if p[j]=='*' then dp[i][j]=dp[i][j-1] or dp[i-1][j]
 */
public class Solution {
	public boolean pan(String p,int j){
		while (j<p.length()){
			if(p.charAt(j++)!='*')return false;
		}
		return true;
	}
 	public boolean compare(String s, String p,int i,int j){
        if(s.length()==i)return p.length()==j || pan(p,j);
 		if(i<s.length()&&j<p.length()){
            if(p.charAt(j)=='?'|| p.charAt(j)==s.charAt(i)){
                return compare(s,p,i+1,j+1);
            }else if(p.charAt(j)=='*'){
                return compare(s,p,i+1,j) || compare(s,p,i,j+1) || compare(s,p,i+1,j+1);
            }
        }
		return false;
	}
	public boolean isMatch(String s, String p) {
		return compare(s,p,0,0);
	}
	public static void main(String args[]) {
		Solution solve = new Solution();
		String s = "a";
		String p = "a*";
		boolean result=solve.isMatch(s,p);
		System.out.println(result);
	}
}

