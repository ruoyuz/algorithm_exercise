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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while(true){
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!list.isEmpty()){
                TreeNode node = list.poll();
                if(node!=null){
                    level.add(node.val);
                    if(node.left!=null) newlist.add(node.left);
                    if(node.right!=null) newlist.add(node.right);
                }
            }
            if(newlist.isEmpty()&&level.isEmpty()) break;
            result.add(0,level);
            list = newlist;
        }
        return result;
    }
}
