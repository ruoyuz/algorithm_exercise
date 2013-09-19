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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        findPath(root,0-sum,path,result);
        return result;
    }
    
    public void findPath(TreeNode node, int current, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result){
        current += node.val;
        path.add(node.val);
        if(node.left==null&&node.right==null&&current==0){
            result.add(new ArrayList<Integer>(path));
        }
        if(node.left!=null) findPath(node.left,current,path,result);
        if(node.right!=null) findPath(node.right,current,path,result);
        path.remove(path.size()-1);
    }
}
