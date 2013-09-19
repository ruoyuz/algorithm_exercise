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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode current = head;
        ListNode shead=null, lhead=null, scurrent=null, lcurrent=null;
        while(current!=null){
            if(current.val<x){
                if(shead==null){
                    shead = current;
                    scurrent = shead;
                }
                else{
                    scurrent.next = current;
                    scurrent = scurrent.next;
                }
            }
            else{
                if(lhead==null){
                    lhead = current;
                    lcurrent = lhead;
                }
                else{
                    lcurrent.next = current;
                    lcurrent = lcurrent.next;
                }
            }
            current = current.next;
        }
        if(shead==null){
            return lhead;
        }
        else if(lhead==null){
            return shead;
        }
        else{
            scurrent.next = lhead;
            lcurrent.next = null;
            return shead;
        }
    }
}
