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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);

        return twoSum(list,k);
    }

    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null)return;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public boolean twoSum(ArrayList<Integer> list , int target) {
        int i = 0;
        int j = list.size()-1;

        while(i<j){
            if(list.get(i)+list.get(j)==target)return true;
            else if(list.get(i)+list.get(j)<target)i++;
            else j--;
        }

        return false;
    }
}
