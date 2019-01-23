package qu_32;

import java.util.ArrayList;
import java.util.List;

class SolutionNew2 {
	public int longestValidParentheses(String s) {
		int len = s.length();
		if (len == 0)
			return 0;
		List<Integer> left = new ArrayList<Integer>();
		int[] tag = new int[len];
		int index = -1;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				left.add(++index, i);
			} else {
				if (index != -1) {
					// int index = left.size() - 1;
					tag[left.get(index--)] = 1;
					// left.remove(index);
					tag[i] = 1;
				}
			}
		}
		int window = 0, result = 0;
		for (int t : tag) {
			System.out.print(t + " ");
			if (t > 0) {
				window++;
			} else {
				if (window > result)
					result = window;
				window = 0;
			}
		}

		return result > window ? result : window;

	}

	public static void main(String[] args) {
		SolutionNew2 s = new SolutionNew2();
		String str = "(()(((()";
		int result = s.longestValidParentheses(str);
		System.out.println();
		System.out.println(result);
	}
}