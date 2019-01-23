package qu_21;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		if (l1.val < l2.val) {
			head.val = l1.val;
			head.next = mergeTwoLists(l1.next, l2);
		} else {
			head.val = l2.val;
			head.next = mergeTwoLists(l1, l2.next);
		}
		return head;
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
