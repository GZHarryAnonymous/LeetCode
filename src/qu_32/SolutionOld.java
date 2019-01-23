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
				if (left == right) {// 之前左括号个数等于右括号个数，且当前为左括号，可能累加
					System.out.println("之前左括号个数等于右括号个数，且当前为左括号，可能累加");
					pre_window=window;//预留之前的结果
					window=0;//重新计数
					left++;
				} else {// 之前右括号个数小于左括号个数，且当前为左括号，左括号个数加一
					System.out.println("之前右括号个数小于左括号个数，且当前为左括号，左括号个数加一");
					left++;
				}
			} else {// 当前为右括号
				System.out.println(')');
				if (right == left) {// 之前右括号个数等于左括号个数，且当前为右括号，重置
					System.out.println("之前右括号个数等于左括号个数，且当前为右括号，重置");
					//if(window>result)result=window;
					left = 0;
					right = 0;
					pre_window = 0;
					window = 0;
				} else {// 之前右括号个数小于左括号个数，且当前为右括号，右括号个数加一
					System.out.println("之前右括号个数小于左括号个数，且当前为右括号，右括号个数加一");
					right++;
					window++;
					if(right==left) {//如果目前左右相等
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