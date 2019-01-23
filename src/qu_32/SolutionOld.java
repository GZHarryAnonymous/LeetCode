package qu_32;

class SolutionOld {
	public int longestValidParentheses(String s) {
		int len = s.length();
		if (len == 0)
			return 0;
		int i = 0;
		while (s.charAt(i) != '(') {
			i++;
			if (i == len)
				return 0;
		}
		int left = 1, right = 0, pre_window = 0, window = 0, result =0;
		i++;
		for (; i < len; i++) {
			if (s.charAt(i) == '(') {
				System.out.println('(');
				if (left == right) {// ֮ǰ�����Ÿ������������Ÿ������ҵ�ǰΪ�����ţ������ۼ�
					System.out.println("֮ǰ�����Ÿ������������Ÿ������ҵ�ǰΪ�����ţ������ۼ�");
					pre_window=window;//Ԥ��֮ǰ�Ľ��
					window=0;//���¼���
					left++;
				} else {// ֮ǰ�����Ÿ���С�������Ÿ������ҵ�ǰΪ�����ţ������Ÿ�����һ
					System.out.println("֮ǰ�����Ÿ���С�������Ÿ������ҵ�ǰΪ�����ţ������Ÿ�����һ");
					left++;
				}
			} else {// ��ǰΪ������
				System.out.println(')');
				if (right == left) {// ֮ǰ�����Ÿ������������Ÿ������ҵ�ǰΪ�����ţ�����
					System.out.println("֮ǰ�����Ÿ������������Ÿ������ҵ�ǰΪ�����ţ�����");
					//if(window>result)result=window;
					left = 0;
					right = 0;
					pre_window = 0;
					window = 0;
				} else {// ֮ǰ�����Ÿ���С�������Ÿ������ҵ�ǰΪ�����ţ������Ÿ�����һ
					System.out.println("֮ǰ�����Ÿ���С�������Ÿ������ҵ�ǰΪ�����ţ������Ÿ�����һ");
					right++;
					window++;
					if(right==left) {//���Ŀǰ�������
						window+=pre_window;
					}
					if(window>result)result=window;
				}
			}
			System.out.println("window"+window);
		}
		return result*2;
	}

	public static void main(String[] args) {
		SolutionOld s = new SolutionOld();
		String str = "(()(((()";
		int result = s.longestValidParentheses(str);
		System.out.println(result);
	}
}