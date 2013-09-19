/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return uniqueTrees(1,n);
    }
    
    public ArrayList<TreeNode> uniqueTrees(int s, int n){
        
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(s>n) result.add(null);
        
        for(int i=s;i<=n;i++){
            for(TreeNode left : uniqueTrees(s,i-1)){
                for(TreeNode right : uniqueTrees(i+1,n)){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
