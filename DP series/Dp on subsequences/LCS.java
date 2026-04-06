class Solution {
    static int match = 0;
    static int notmatch = 0;
    
    static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        return func(n1-1,n2-1,s1,s2);
    }
    
    static int func(int ind1,int ind2,String s1,String s2) {
        if(ind1<0 || ind2<0)return 0;
        
        int match = 0;
        int notmatch = 0;
        
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            match =  1 + func(ind1-1,ind2-1,s1,s2);
        }else{
            notmatch = Math.max(func(ind1-1,ind2,s1,s2),func(ind1,ind2-1,s1,s2));
        }
        
        return Math.max(match,notmatch);
    }
}



class Solution {
    static int match = 0;
    static int notmatch = 0;
    
    static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        return func(n1-1,n2-1,s1,s2,dp);
    }
    
    static int func(int ind1,int ind2,String s1,String s2,int[][] dp) {
        if(ind1<0 || ind2<0)return 0;
        
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        
        int match = 0;
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] =  1 + func(ind1-1,ind2-1,s1,s2,dp);
        }
        
        return dp[ind1][ind2] = Math.max(func(ind1-1,ind2,s1,s2,dp),func(ind1,ind2-1,s1,s2,dp));
    }
}


class Solution {
    static int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        for(int ind1 = 1 ; ind1 <= n1 ; ind1++){
            for(int ind2 = 1 ; ind2 <= n2 ; ind2++){
                int match = 0;
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2] =  1 + dp[ind1-1][ind2-1];
                }else dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        
        return dp[n1][n2];
    }
}
