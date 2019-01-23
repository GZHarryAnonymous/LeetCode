package qu_19;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        if (head == null) return head;
	        int i = 0;
	        ListNode lead = head;
	        ListNode tail = head;
	        while (i < n && lead.next != null) { 
	            lead = lead.next;
	            i++;
	        }
	        if (lead.next == null && i <n) {
	            return tail.next;
	        }
	        while(lead.next!= null) {
	            lead = lead.next;
	            tail = tail.next;
	        }
	        tail.next = tail.next.next;
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
