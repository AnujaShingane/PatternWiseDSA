class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        return n-lps(s);
    }

    public int lps(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return lcs(s,sb.toString());
    }

    public int lcs(String s1,String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(n1-1,n2-1,s1,s2,dp);
    }

    public int func(int ind1,int ind2,String s1,String s2,int[][] dp) {
        if(ind1<0 || ind2<0)return 0;

        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];

        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + func(ind1-1,ind2-1,s1,s2,dp);
        }else{
            return dp[ind1][ind2] = Math.max(func(ind1-1,ind2,s1,s2,dp),func(ind1,ind2-1,s1,s2,dp));
        }
    }
}
