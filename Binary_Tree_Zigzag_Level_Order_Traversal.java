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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        list.push(root);
        int i=1;
        while(true){
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!list.isEmpty()){
                TreeNode node = list.pop();
                if(node!=null){
                    level.add(node.val);
                    if(i%2==1){
                        newlist.push(node.left);
                        newlist.push(node.right);
                    }
                    else{
                        newlist.push(node.right);
                        newlist.push(node.left);
                    }
                }
            }
            if(level.isEmpty()) break;
            else result.add(level);
            i++;
            list = newlist;
        }
        return result;
    }
}
