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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if(root==null) return 0;
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<Integer> numSet = new ArrayList<Integer>();
        getNums(root,path,numSet);
        int n=0;
        for(Integer i:numSet){
            n += i;
        }
        return n;
    }

    public void getNums(TreeNode node, ArrayList<Integer> path, ArrayList<Integer> numSet){
        
        path.add(node.val);
        if(node.left==null&&node.right==null) numSet.add(toNum(path));
        if(node.left!=null) getNums(node.left,path,numSet);
        if(node.right!=null) getNums(node.right,path,numSet);
        path.remove(path.size()-1);
    }

    public int toNum(ArrayList<Integer> path){
        int n=0;
        for(Integer i:path){
            n *= 10;
            n += i;
        }
        return n;
    }
}

