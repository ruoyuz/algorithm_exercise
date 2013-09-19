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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode current = head, pre=null;
        Stack<ListNode> stack = new Stack<ListNode>();
        for(int i=1;i<m-1;i++){
            current = current.next;
        }
        if(m!=1){
            pre = current;
            current = current.next;
        }
        
        for(int i=m;i<=n;i++){
            stack.push(current);
            current = current.next;
        }
        
        ListNode rHead = stack.peek();
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            if(stack.isEmpty()) node.next=current;
            else node.next=stack.peek();
        }
        
        if(m!=1) pre.next = rHead;
        else head = rHead;
        return head;
    }
}
