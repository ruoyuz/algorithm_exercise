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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return constructBST(num,0,num.length);
    }
    
    public TreeNode constructBST(int[] num, int i, int j){
        if(i==j) return null;
        int mid = (i+j)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = constructBST(num,i,mid);
        node.right = constructBST(num,mid+1,j);
        return node;
    }
}
