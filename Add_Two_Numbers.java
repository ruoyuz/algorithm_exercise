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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry=0;
        while(current!=null){
            int a=0, b=0;
            if(l1!=null) {a=l1.val; l1=l1.next;}
            if(l2!=null) {b=l2.val; l2=l2.next;}
            current.val = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            current.next = new ListNode(0);
            if(l1==null&&l2==null&&carry==0) current.next = null;
            current = current.next;
        }
        return result;
    }
}
