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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(current==null) return list;
        stack.push(current);
        
        while(!stack.isEmpty()){
            while(current.left!=null){
                current = current.left;
                stack.push(current);
            }
            while(!stack.isEmpty()){
                current = stack.pop();
                list.add(current.val);
                if(current.right!=null){
                    current = current.right;
                    stack.push(current);
                    break;
                }
            }
        }
        return list;
    }
}
