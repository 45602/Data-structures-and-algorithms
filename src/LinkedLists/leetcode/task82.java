package LinkedLists.leetcode;

class task82 {
	
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
    public static ListNode deleteDuplicates(ListNode head) {
    
        if(head == null) { 
            return null;
        }
        
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null) { 
            boolean duplicates = false;
            while(temp.next != null && temp.val == temp.next.val) { 
                duplicates = true;
                temp.next = temp.next.next;
            }
            if(duplicates) {
                if(temp.val == head.val) { 
                    head = head.next;
                }
                else {
                    prev.next = temp.next;
                    temp = temp.next;
                }
            }
            else {
            	prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
