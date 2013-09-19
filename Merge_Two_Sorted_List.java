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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(l1!=null&&l2!=null){
            if(l1.val>=l2.val){
                current.next = l2;
                l2 = l2.next;
            }
            else{
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        while(l1!=null){
            current.next = l1;
            current =current.next;
            l1 = l1.next;
        }
        while(l2!=null){
            current.next = l2;
            current =current.next;
            l2 = l2.next;
        }
        return head.next;
    }
}
