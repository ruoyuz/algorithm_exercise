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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> cache = new ArrayList<TreeNode>(1);
        ArrayList<TreeNode> list = new ArrayList<TreeNode>(2);
        inorderCheck(root,cache,list);
        if(!list.isEmpty()){
            TreeNode n1 = list.get(0);
            TreeNode n2 = list.get(1);
            int swap = n1.val;
            n1.val = n2.val;
            n2.val = swap;
        }
    }
    
    public void inorderCheck(TreeNode root, ArrayList<TreeNode> cache, ArrayList<TreeNode> list){
        if(root==null) return;
        inorderCheck(root.left,cache,list);
        if(cache.isEmpty()) cache.add(root);
        else{
            TreeNode pre = cache.get(0);
            if(pre.val>=root.val){
                if(list.isEmpty()){
                    list.add(pre);
                    list.add(root);
                }
                else{
                    list.set(1,root);
                }
            }
            cache.set(0,root);
        }
        inorderCheck(root.right,cache,list);
    }
}
