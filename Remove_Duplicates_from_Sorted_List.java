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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode current = head;
        ListNode point = current;
        while(point!=null){
            if(current.val==point.val) point = point.next;
            else{
                current.next = point;
                current = current.next;
            }
        }
        if(current!=null) current.next = null;
        return head;
    }
}
