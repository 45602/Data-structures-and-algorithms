package LinkedLists.leetcode;

public class task61 {

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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null) { 
            return null;
        }
        if(k == 0 || head.next == null) { 
            return head;
        }
        ListNode temp = head;
        int cnt = 0;
        while(cnt<length(head)-k%length(head)-1) { 
            temp = temp.next;
            cnt++;
        }
        ListNode breakPoint = temp;
        while(temp.next!=null) { 
            temp = temp.next;
        }
        temp.next = head;
        head = breakPoint.next;
        breakPoint.next = null;
        
        return head;
    }
    
    public int length(ListNode head) { 
        int cnt = 0;
        if(head == null) { 
            return cnt;
        }
        cnt++;
        ListNode temp = head;
        while(temp.next!= null) { 
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}
