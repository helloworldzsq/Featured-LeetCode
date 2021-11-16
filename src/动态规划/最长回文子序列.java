package 动态规划;

public class 最长回文子序列 {

    public int longHuiwen(String s){
        int n=s.length();
        //dp数组的含义   在子串s[i...j]中最长回文子串为dp[i][j]
        int[][] dp = new int[n][n];
        //初始化  只有一个字符（i==j) 最大为1
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }
        //因为i小于j，所以使用矩形的上半部分
        /*假设知道dp[i+1][j-1]最长回文子序列的长度
           如果s[i] == s[j], dp[i][j] = dp[i+1][j-1]+2
           如果s[i] != s[j], dp[i][j] = max(dp[i+1][j],dp[i,j-1])
           要得到dp[i][j],必须知道三个位置的dp值，画出dp矩阵，可以看出需要从下向上遍历
        */
        for (int i = n-1; i>=0; i--) {
            for (int j = i+1; j <n ; j++) {
                if (s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}
