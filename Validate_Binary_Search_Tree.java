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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValid(root,null,null);
    }
        
        
    public boolean isValid(TreeNode root, TreeNode min, TreeNode max){
        if(root==null) return true;
        if(min!=null&&root.val<=min.val) return false;
        if(max!=null&&root.val>=max.val) return false;
        return isValid(root.left,min,root)&&isValid(root.right,root,max);
    }
}
