package qu_23;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		int amount = lists.length, interval = 1;
		while (interval < amount) {
			for (int i = 0; i < amount - interval; i += interval) {
				lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
				// lists[i].print();
			}
			interval *= 2;
		}
		// return lists[0];
		return amount == 0 ? null : lists[0];
	}
		/***
	    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null)return l2;
	        if(l2==null)return l1;
	        ListNode head=null,cur=null;
	            if(l1.val<l2.val){
	                head=l1;
	                l1=l1.next;
	                cur=head;
	            }else{
	                head=l2;
	                l2=l2.next;
	                cur=head;
	            }
	        while(l1!=null&&l2!=null){
	            if(l1.val<l2.val){
	                cur.next=l1;
	                l1=l1.next;
	                cur=cur.next;
	            }else{
	                cur.next=l2;
	                l2=l2.next;
	                cur=cur.next;
	            }
	        }
	        if(l1==null)cur.next=l2;
	        if(l2==null)cur.next=l1;
	        return head;
	    }
	    ***/
	    
	    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null)return l2;
	        if(l2==null)return l1;
	        ListNode head=new ListNode(0);
	            if(l1.val<l2.val){
	                head.val=l1.val;
	                head.next=mergeTwoLists(l1.next,l2);
	            }else{
	                head.val=l2.val;
	                head.next=mergeTwoLists(l1,l2.next);
	            }
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
