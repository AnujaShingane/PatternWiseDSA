/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
*/


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        hasPathSum(root,targetSum,path,res);
        return res;
    }

    public void hasPathSum(TreeNode root, int targetSum,List<Integer> path,List<List<Integer>> res) {
        if(root==null)return;
        path.add(root.val);

        if(root.left==null && root.right==null){
            if(root.val==targetSum){
                res.add(new ArrayList<>(path));
            }
        }else{
            int remaining = targetSum-root.val;
            hasPathSum(root.left,remaining,path,res);
            hasPathSum(root.right,remaining,path,res);
        }
        
        path.remove(path.size()-1); //backtrack
    }
}
