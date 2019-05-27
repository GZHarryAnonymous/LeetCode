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
/*相关说明：
 *基于LeetCode平台算法的一个刷题记录！
 *已经共享至public repository，链接如下：
 *https://github.com/GZHarryAnonymous/LeetCode
 *欢迎题友们fork、push纠正相关错误、交流相关问题！(别忘了给颗星哦！)
 *个人博客：https://gzharryanonymous.github.io/
 *欢迎来访！当然，如果来访还打赏就更好啦！！！
 *能力有限，希望有帮到你！
 **/
