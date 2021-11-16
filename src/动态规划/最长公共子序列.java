package 动态规划;
public class 最长公共子序列 {

    public int longestCommonSubsequence(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        //dp[i][j] 的含义是 s1[0,i-1],s2[0,j-1] 最长公共子序列的长度
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    //这里其实是max(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]),但是dp[i-1][j-1]总是小于等于dp[i][j-1]
                    //或者dp[i-1][j],所以dp[i-1][j-1]省略不写
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
