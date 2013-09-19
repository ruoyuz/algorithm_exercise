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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashMap<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();
        int H = treeHeight(root,map);
        return !map.containsValue(false);
    }
    
    public int treeHeight(TreeNode root, HashMap<TreeNode, Boolean> map){
        if(root==null) return 0;
        int left = treeHeight(root.left,map);
        int right = treeHeight(root.right,map);
        int height = Math.max(left,right)+1;
        if(Math.abs(left-right)>1) map.put(root, false);
        return height;
    }
}
