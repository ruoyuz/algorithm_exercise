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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(k<2) return head;
        Stack<ListNode> NS = new Stack<ListNode>();
        ListNode current = head;
        int i = 0;
        while(current!=null){
            if(i%k==0) NS.push(current);
            current=current.next;
            i++;
        }
        ListNode h=null;
        if(i%k!=0) h=NS.pop();
        while(!NS.isEmpty()){
            ListNode p = NS.pop();
            h = revK(p,h, k);
        }
        return h;
    }
    
    public ListNode revK(ListNode p, ListNode h, int k){
        Stack<ListNode> NS = new Stack<ListNode>();
        ListNode current=p, head, temp;
        NS.push(h);
        for(int i=0; i<k; i++){
            NS.push(current);
            current = current.next;
        }
        temp = NS.pop();
        head = temp;
        while(!NS.isEmpty()){
            current = temp;
            temp = NS.pop();
            current.next = temp;
        }
        return head;
    }
}
