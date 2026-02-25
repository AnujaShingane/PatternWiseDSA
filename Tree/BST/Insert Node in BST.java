TC -> O(log N) Worst case -> O(N)
SC -> O(1)

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        if(root == null){
            return new TreeNode(val);
        }

        while(node!=null){
            int curVal = node.val;
            TreeNode curNode = node;

            if(val>curVal){
                node = node.right;
                if(node==null){
                    curNode.right=new TreeNode(val);
                }
            }else if(val<curVal){
                node = node.left;
                if(node==null){
                    curNode.left=new TreeNode(val);
                }
            }
        }

        return root;
    }
}
