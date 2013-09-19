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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        preorder(root, list);
        TreeNode current = null;
        while(!list.isEmpty()){
            current = list.poll();
            current.left = null;
            if(list.isEmpty()) current.right = null;
            else current.right = list.peek();
        }
    }
    
    public void preorder(TreeNode node, LinkedList<TreeNode> list){
        if(node==null) return;
        list.add(node);
        preorder(node.left,list);
        preorder(node.right,list);
    }
}
