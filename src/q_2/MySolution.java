package q_2;

class MySolution {
	ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode result = null;
		if (l1 == null && l2 == null) {
			return result;
		}
		if (l1 == null) {
			result = new ListNode(l2.val);
			ListNode head = result;
			while (l2.next != null) {
				result.next = new ListNode(l2.next.val);
				l2 = l2.next;
				result = result.next;
			}
			return head;
		} else if (l2 == null) {
			result = new ListNode(l1.val);
			ListNode head = result;
			while (l1.next != null) {
				result.next = new ListNode(l1.next.val);
				l1 = l1.next;
				result = result.next;
			}
			return head;
		} else {
			int val = l1.val + l2.val;
			if (val > 9) {
				val = val - 10;
				result = addTwoNumbers(result, new ListNode(val));
				if (l1.next == null && l2.next == null) {
					result.next = new ListNode(1);
				} else {
					l1.next = addTwoNumbers(l1.next, new ListNode(1));
					result.next = addTwoNumbers(l1.next, l2.next);
				}
			} else {
				result = new ListNode(val);
				result.next = addTwoNumbers(l1.next, l2.next);
			}
			return result;
		}
	}
}

