package qu_24;
import java.util.*;

public class Solution {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	    public ListNode swapPairs(ListNode head) {
	        if(head==null||head.next==null)return head;
	        int val = head.val;
	        head.val = head.next.val;
	        head.next.val = val;
	        swapPairs(head.next.next);
	        return head;
	    }
	
	public static void main(String args[]) {
		Solution s = new Solution();
		Scanner sc =  new Scanner(System.in);
		int  tmp;
		ListNode head;
		System.out.println("please input the number:");
		if((tmp=sc.nextInt())!=-1){
			ListNode node = new ListNode(tmp);
			head = node;
			while((tmp=sc.nextInt())!=-1){
				node.next = new ListNode(tmp);
				node = node.next;
			}
			s.swapPairs(head);
			while(head!=null){
				System.out.println(head.val);
				head=head.next;
			}

		}else{
			System.out.println("Your input is ended!");
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
