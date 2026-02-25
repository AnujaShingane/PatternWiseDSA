TC -> O(log N)
SC -> O(N)

/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int x) {
        int floor = -1;
        
        while(root!=null){
            if(root.data==x){
                return x;
            }else if(root.data<x){
                floor = root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        
        return floor;
    }
}
