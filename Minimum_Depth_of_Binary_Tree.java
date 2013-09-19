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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(root==null) return 0;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int i=1;
        while(true){
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            while(!list.isEmpty()){
                TreeNode node = list.poll();
                if(node!=null){
                    if(node.left==null&&node.right==null) return i;
                    if(node.left!=null) newlist.add(node.left);
                    if(node.right!=null) newlist.add(node.right);
                }
            }
            list = newlist;
            i++;
        }
    }
}
