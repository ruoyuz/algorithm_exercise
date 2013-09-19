/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(head==null) return null;
        
        ListNode current = head;
        int i = 0;
        while(current!=null){
            i++;
            current = current.next;
        }
        TreeNode root = buildTree(i);
        fillTree(head, root);
        return root;
    }
    
    public TreeNode buildTree(int i){
        int j=0,k=0;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(0);
        if(++j>=i) return root;
        list.add(root);
        
        while(true){
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            while(!list.isEmpty()){
                TreeNode node = list.poll();
                node.left = new TreeNode(0);
                if(++j>=i) return root;
                node.right = new TreeNode(0);
                if(++j>=i) return root;
                
                newlist.add(node.left);
                newlist.add(node.right);
            }
            list = newlist;
        }
    }
    
    public ListNode fillTree(ListNode head, TreeNode root){
        if(root==null&&head==null) return null;
        else if(root==null) return head;
        head = fillTree(head,root.left);
        root.val = head.val;
        head = head.next;
        head = fillTree(head,root.right);
        return head;
    }
}
