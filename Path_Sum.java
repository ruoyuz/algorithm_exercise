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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return false;
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        LinkedList<Integer> numList = new LinkedList<Integer>();
        nodeList.add(root);
        numList.add(root.val);
        
        while(true){
            LinkedList<TreeNode> newNodeList = new LinkedList<TreeNode>();
            LinkedList<Integer> newNumList = new LinkedList<Integer>();
            while(!nodeList.isEmpty()){
                TreeNode node = nodeList.poll();
                int num = numList.poll();
                if(node.left==null&&node.right==null&&num==sum) return true;
                if(node.left!=null){
                    int numleft = num+node.left.val;
                    newNodeList.add(node.left);
                    newNumList.add(numleft);
                }
                if(node.right!=null){
                    int numright = num+node.right.val;
                    newNodeList.add(node.right);
                    newNumList.add(numright);
                }
            }
            if(newNodeList.isEmpty()) break;
            nodeList = newNodeList;
            numList = newNumList;
        }
        return false;
    }
}
