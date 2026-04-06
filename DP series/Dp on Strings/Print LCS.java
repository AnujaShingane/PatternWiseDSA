public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        StringBuilder sb = new StringBuilder();
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
        
        int i = n1;
        int j = n2;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i=i-1;
                j=j-1;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i=i-1;
                }else{
                    j=j-1;
                }
            }
        }

        return sb.reverse().toString();
    }

    public static String findLCS(int n, int m, String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return func(n-1,m-1,s1,s2,dp);
    }

    public static int func(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(i<0 || j<0)return 0;

        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];

        int match = 0;
        int notmatch = 0;
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = func(ind1-1,ind2-1,s1,s2,dp);
        }else{
            return dp[ind1][ind2] = Math.max(func(ind1,ind2-1,s1,s2,dp),func(ind1-1,ind2,s1,s2,dp));
        }
    }
}
