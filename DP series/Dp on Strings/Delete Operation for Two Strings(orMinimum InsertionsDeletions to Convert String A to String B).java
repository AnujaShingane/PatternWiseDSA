class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        return n1+n2-2*lcs(word1,word2);
    }

    public static int lcs(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(n1-1,n2-1,s1,s2,dp);
    }

    public static int func(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0)return 0;

        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];

        int match = 0;
        int notmatch = 0;
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + func(ind1-1,ind2-1,s1,s2,dp);
        }else{
            return dp[ind1][ind2] = Math.max(func(ind1,ind2-1,s1,s2,dp),func(ind1-1,ind2,s1,s2,dp));
        }
    }
}
