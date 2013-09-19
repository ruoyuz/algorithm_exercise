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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return true;
        return isSymTrees(root.left,root.right);
    }

    public boolean isSymTrees(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null||q==null){
            if(p==q) return true;
            else return false;
        }
        
        if(p.val==q.val) return isSymTrees(p.left,q.right)&&isSymTrees(p.right,q.left);
        else return false;
    }
}
