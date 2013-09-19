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
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] cache = new int[1];
        cache[0] = root.val;
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        findMax(root,cache,map);
        return cache[0];
    }
    public int sidePathSum(TreeNode root, HashMap<TreeNode, Integer> map){
        
        if(map.containsKey(root)) return map.get(root);
        
        int left=0, right=0, max;
        if(root.left!=null&&root.right!=null){
            left = root.val+sidePathSum(root.left,map);
            right = root.val+sidePathSum(root.right,map);
            max = Math.max(left,right);
            max = Math.max(max,root.val);
        }
        else if(root.left!=null){
            left = root.val+sidePathSum(root.left,map);
            max = Math.max(left,root.val);
        }
        else if(root.right!=null){
            right = root.val+sidePathSum(root.right,map);
            max = Math.max(right,root.val);
        }
        else max = root.val;
        map.put(root,max);
        return max;
    }
    
    public void findMax(TreeNode root, int[] cache, HashMap<TreeNode, Integer> map){
        if(root==null) return;
        else{
            findMax(root.left,cache,map);
            findMax(root.right,cache,map);
            if(root.left==null||root.right==null) cache[0] = Math.max(cache[0],sidePathSum(root,map));
            else{
                int left = sidePathSum(root.left,map);
                int right = sidePathSum(root.right,map);
                cache[0] = Math.max(cache[0],root.val+left);
                cache[0] = Math.max(cache[0],root.val+right);
                cache[0] = Math.max(cache[0],root.val+left+right);
            }
        }
    }
}
