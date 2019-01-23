package qu_31;

//Definition for singly-linked list.
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
	public void print() {
		ListNode t = this;
		while(t!=null) {
			System.out.print(" "+t.val);
			t=t.next;
		}
		System.out.println();
	}
}
