import java.util.*;

class DisjointSet{
  ArrayList<Integer> rank = new ArrayList<>();
  ArrayList<Integer> parent = new ArrayList<>();
  
  DisjointSet(int n){
    for(int i = 0 ; i <= n ; i++){
      rank.add(0);
      parent.add(i);
    }
  }
  
  public int findUPar(int node){
    if(node == parent.get(node))return node;
    
    int ulp = findUPar(parent.get(node));
    parent.set(node,ulp);
    return parent.get(node);
  }
  
  public void unionByParent(int u , int v){
    int ulp_u = findUPar(u);
    int ulp_v = findUPar(v);
    
    if(ulp_v==ulp_u)return;
    
    if(rank.get(ulp_u)<rank.get(ulp_v)){
      parent.set(ulp_u,ulp_v);
    }else if(rank.get(ulp_u)>rank.get(ulp_v)){
      parent.set(ulp_v,ulp_u);
    }else{
      parent.set(ulp_u,ulp_v);
      rank.set(ulp_u,rank.get(ulp_u)+1);
    }
  }
}

public class Solution{
  public static void main(String args[]){
    DisjointSet ds = new DisjointSet(7);
    ds.unionByParent(1,2);
    ds.unionByParent(2,3);
    ds.unionByParent(4,5);
    ds.unionByParent(6,7);
    ds.unionByParent(5,6);
    
    if(ds.findUPar(3)==ds.findUPar(7)){
      System.out.println("Same");
    }else{
      System.out.println("Not Same");
    }
    
    ds.unionByParent(3,7);
    
    if(ds.findUPar(3)==ds.findUPar(7)){
      System.out.println("Same");
    }else{
      System.out.println("Not Same");
    }
  }
}


Output:
Not Same
Same
