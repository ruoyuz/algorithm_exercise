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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lp=preorder.length, li=inorder.length;
        int i=0,p=0;
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        TreeNode root = null, current=null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(i<li){
            if(i<li&&map.containsKey(inorder[i])){
                current = stack.pop();
                i++;
            }
            else{
                if(p==lp) break;
                TreeNode node = new TreeNode(preorder[p]);
                if(root==null) root = node;
                else if(current==null) stack.peek().left = node;
                else{
                    current.right = node;
                    current = null;
                }
                stack.add(node);
                map.put(preorder[p],true);
                p++;
            }
        }
        return root;
    }
}
