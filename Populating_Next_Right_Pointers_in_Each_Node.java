/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(root==null) return;
        
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.add(root);
        
        while(true){
            LinkedList<TreeLinkNode> newlist = new LinkedList<TreeLinkNode>();
            while(!list.isEmpty()){
                TreeLinkNode node = list.poll();
                if(!list.isEmpty()) node.next=list.peek();
                else node.next=null;
                if(node.left!=null) newlist.add(node.left);
                if(node.right!=null) newlist.add(node.right);
            }
            if(newlist.isEmpty()) return;
            list = newlist;
        }
    }
}
