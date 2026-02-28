/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        
        int predecessor = bsp(list,key,list.size());
        int successor = bss(list,key,list.size());
        
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(new Node(predecessor));
        ans.add(new Node(successor));
        
        return ans;
    }
    
    public void inorder(Node root,ArrayList<Integer> arr){
        if(root==null)return;
        
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    
    public int bsp(ArrayList<Integer>list ,int key,int n){
        int low = 0;
        int high = n-1;
        int ans = -1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(list.get(mid)==key){
                high=mid-1;
            }else if(list.get(mid)>key){
                high=mid-1;
            }else{
                ans = list.get(mid);
                low=mid+1;
            }
        }
        
        return ans;
    }
    
    public int bss(ArrayList<Integer>list ,int key,int n){
        int low = 0;
        int high = n-1;
        int ans = -1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(list.get(mid)==key){
                low=mid+1;
            }else if(list.get(mid)<key){
                low=mid+1;
            }else{
                ans = list.get(mid);
                high=mid-1;
            }
        }
        
        return ans;
    }
}
