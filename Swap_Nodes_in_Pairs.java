/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || head.next==null) return head;
        ListNode current=head, previous;
        head = head.next;
        while(current!=null && current.next!=null){
            previous = current;
            current = current.next;
            previous.next = current.next;
            current.next = previous;
            current = previous.next;
            if(previous.next!=null && previous.next.next!=null) previous.next=previous.next.next;
        }
        return head;
    }
}
