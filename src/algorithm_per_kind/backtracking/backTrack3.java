package algorithm_per_kind.backtracking;

//https://blog.csdn.net/sinat_27908213/article/details/80599460
public class backTrack3 {
	public static void main(String[] args) {
		String s = "abc";
		pailie(s, "");
	}

	public static void pailie(String s, String temp) {//������Ƶؾ����ؼ��
		if (s.length() == 0) {
			System.out.println(temp);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String news = s.substring(0, i) + s.substring(i + 1, s.length());//ȥ��String�е�ĳ����ĸ
			pailie(news, temp + s.charAt(i));
		}
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