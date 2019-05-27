package algorithm_per_kind.backtracking;

import java.util.ArrayList;

//https://blog.csdn.net/sinat_27908213/article/details/80599460
public class backTrack {
	public static void main(String[] args) {
		int n = 3;
		int leftnum = n, rightnum = n;//�����ź������Ŷ�����n��
		ArrayList<String> results = new ArrayList<String>();//���ڴ�Ž�ռ�
		parentheses("", results, leftnum, rightnum);
		for (String s : results)
			System.out.println(s);
	}

	public static void parentheses(String sublist, ArrayList<String> results, int leftnum, int rightnum) {
		if (leftnum == 0 && rightnum == 0)//����
			results.add(sublist);
		if (leftnum > 0)
			parentheses(sublist + "(", results, leftnum - 1, rightnum);
		if (rightnum > leftnum)//ѡ������������ڲ�ͬ��if˳������Ľ��˳���ǲ�һ���ģ����ǹ���һ���Ľ�ռ�
			parentheses(sublist + ")", results, leftnum, rightnum - 1);

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