package LinkedLists.leetcode;

/* idea is to have 2 pointers, both starting at same position but not in the same time.
when first one reaches node number k, second one starts and we know that their gap is exactly k
when first one reaches end, second one will be exactly k positions away from end)
*/
public class task19 {
	
	static class ListNode {
		
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { 
			this.val = val; 
		}
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
	}
	
	 public ListNode removeNthFromEnd(ListNode head, int n) {
			
			if(head == null) {          //if list has no elements, return null;
				head = null;
	            return head;
	        }
			ListNode temp1 = head, temp2 = head; 
			int cnt = 1;
			while(cnt != n) { 
				temp1 = temp1.next;
				cnt++;
			}                           //at this point, first one reached k-th position so second one is about to start
	        ListNode prev = null;       //since we want to remove the element on position k, we ll have to remember the element before it (element before head is null)
			while(temp1.next !=null) { 
				temp1 = temp1.next;
	            prev = temp2;
				temp2 = temp2.next;
			}
	        if(prev == null) {         //if prev is still null, that means that we have to remove head
	            head = head.next;
	        }
	        else {
			    prev.next = prev.next.next;
	        }
			return head;
		}
}
