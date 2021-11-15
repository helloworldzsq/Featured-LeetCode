package 动态规划;


//题目描述：给定两个字符串s1，s2，只能用三种操作（插入，删除，替换），将s1变成s2，求最少的操作数。
// 题目链接： https://leetcode-cn.com/problems/edit-distance/
public class 编辑距离 {

    public int mindistance(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        //下面做的所有操作是为了将s1变为s2
        int[][] dp = new int[m + 1][n + 1];
        // s2长度为0, s1变为s2的操作数为s1的长度
        for (int i = 0; i < m + 1; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j]=j;
        }
        //这道题中最难理解的就是下边的状态转移方程
        //可以把i,j当做从字符串最后向前移动的指针，且只对s1进行操作
        //插入  dp[i][j-1]+1  i不变，j向前，操作数加1
        //删除  dp[i-1][j]+1  i向前，j不变，操作数加1
        //替换  dp[i-1][j-1]+1  i,j同时向前，操作数加1
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j <n+1; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
            }
        }
        return dp[m][n];
    }
    private int min(int i, int j, int k) {
        return Math.min(i,Math.min(j,k));
    }

}
