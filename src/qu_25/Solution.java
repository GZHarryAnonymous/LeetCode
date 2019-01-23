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
/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/
