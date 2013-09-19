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
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int i=0;
        while(true){
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            while(!list.isEmpty()){
                TreeNode node = list.poll();
                if(node!=null){
                    newlist.add(node.left);
                    newlist.add(node.right);
                }
            }
            if(newlist.isEmpty()) break;
            list = newlist;
            i++;
        }
        return i;
    }
}
