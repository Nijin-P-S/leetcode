/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, Integer> maxLen = new HashMap<>();
    public int diam(TreeNode root){
        if(root == null)
            return 0;
        if(maxLen.get(root) != null)
            return maxLen.get(root);
        int left = 1+diam(root.left);
        int right = 1+diam(root.right);
        
        maxLen.put(root,Math.max(left, right));
        return Math.max(left, right);
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int curLeft = diam(root.left);
        int curRight = diam(root.right);
        
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        return Math.max(curLeft+curRight, Math.max(left, right));
    }
}