TC -> O(n)
SC -> Recursive Inorder
      Uses call stack
      Space: O(h)
      Balanced BST → O(log n)
      Skewed BST → O(n)

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
    int cnt = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }

    public void inorder(TreeNode root , int k){
        if(root == null)return;

        inorder(root.left,k);

        cnt++;
        if(cnt==k){
            result=root.val;
            return;
        }

        inorder(root.right,k);
    }
}
