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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lp=postorder.length, li=inorder.length;
        int i=li-1,p=lp-1;
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        TreeNode root = null, current=null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(i>-1){
            if(i>-1&&map.containsKey(inorder[i])){
                current = stack.pop();
                i--;
            }
            else{
                if(p==-1) break;
                TreeNode node = new TreeNode(postorder[p]);
                if(root==null) root = node;
                else if(current==null) stack.peek().right = node;
                else{
                    current.left = node;
                    current = null;
                }
                stack.add(node);
                map.put(postorder[p],true);
                p--;
            }
        }
        return root;
    }
}
