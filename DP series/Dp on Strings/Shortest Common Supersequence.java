class Solution {
    int[][] dp;
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        lcs(str1,str2);
        StringBuilder sb = new StringBuilder();

        int i = n1;
        int j = n2;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i=i-1;
                j=j-1;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(str1.charAt(i-1));
                    i=i-1;
                }else{
                    sb.append(str2.charAt(j-1));
                    j=j-1;
                }
            }
        }

        while(i>0){
            sb.append(str1.charAt(i-1));
            i=i-1;
        }

        while(j>0){
            sb.append(str2.charAt(j-1));
            j=j-1;
        }

        return sb.reverse().toString();
    }

    public int lcs(String s1,String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        dp = new int[n1+1][n2+1];

        for(int i = 1; i <= n1 ; i++){
            for(int j = 1 ; j <= n2 ; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n1][n2];
    }
}
