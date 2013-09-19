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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if(head==null||head.next==null) return head;
        ListNode pointer = head;
        int num = 1;
        while(pointer.next!=null){
            num++;
            pointer=pointer.next;
        }
        
        n=n%num;
        pointer.next=head;
        pointer=head;
        for(int i=1;i<num-n;i++){
            pointer = pointer.next;
        }
        
        ListNode newHead = pointer.next;
        pointer.next = null;
        return newHead;
    }
}
