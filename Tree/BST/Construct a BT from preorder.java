TC -> O(n)
SC -> O(1) -----else
      O(h) -------recursion stack space
  

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode bst(int[] preorder, int bound , int[] index){
        if(index[0]==preorder.length || preorder[index[0]]>bound)return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);

        root.left = bst(preorder,root.val,index);
        root.right = bst(preorder,bound,index);

        return root;
    }
}
