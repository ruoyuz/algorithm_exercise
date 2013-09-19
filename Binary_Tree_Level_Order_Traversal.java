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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        list.add(root);
        while(true){
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!list.isEmpty()){
                TreeNode node = list.poll();
                if(node!=null){
                    level.add(node.val);
                    newlist.add(node.left);
                    newlist.add(node.right);
                }
            }
            if(level.isEmpty()) break;
            else result.add(level);
            list = newlist;
        }
        return result;
    }
}
