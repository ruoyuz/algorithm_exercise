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
        if(head==null) return head;
        ListNode valid = null;
        ListNode validHead = null;
        ListNode current = head;
        int val = current.val;
        
        while(current!=null){
            ListNode next = current.next;
            if((current==head||current.val!=val)&&(next==null||next.val!=current.val)){
                if(validHead==null){
                    validHead = current;
                    valid = current;
                }
                else{
                    valid.next = current;
                    valid = valid.next;
                }
                current = current.next;
            }
            else{
                val = current.val;
                current = current.next;
            }
        }
        if(valid!=null) valid.next = null;
        return validHead;
    }
}
