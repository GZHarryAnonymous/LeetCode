package qu_25;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; } }
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k < 2)
			return head;
		int step = 1;
		ListNode tail = head, tmp = null, t = null;
		while (step < k && tail != null && tail.next != null) {
			tail = tail.next;
			step++;
		}
		if (step < k)
			return head;
		t = head;
		while (head != tail) {
			tmp = head.next;
			head.next = tail.next;
			tail.next = head;
			head = tmp;
		}
		t.next = reverseKGroup(t.next, k);
		return head;
	}
	
	public static void main(String args[]) {
		Solution s = new Solution();
		int result=0;
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
