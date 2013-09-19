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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode current = head;
        if(head.next==null) return null;
        for(int i=1; i<n; i++){
            if(current==null) return head;
            current=current.next;
        }
        ListNode mark = head;
        if(n==1) current = current.next;
        while(current.next!=null){
            current=current.next;
            mark=mark.next;
        }
        if(n==1){
            mark.next = mark.next.next;
        }
        else{
            mark.val = mark.next.val;
            mark.next = mark.next.next;
        }
        return head;
    }
}
