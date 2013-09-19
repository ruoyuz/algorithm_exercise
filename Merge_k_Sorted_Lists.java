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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
            new Comparator<ListNode>(){
                public int compare(ListNode n1, ListNode n2){
                    return n1.val-n2.val;
                }
            });
            
        for(ListNode node : lists){
            if(node!=null) heap.add(node);
        }
        
        ListNode head = heap.peek();
        
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            ListNode newNode = node;
            newNode = node.next;
            if(newNode!=null) heap.add(newNode);
            node.next = heap.peek();
        }
        return head;
    }
}
