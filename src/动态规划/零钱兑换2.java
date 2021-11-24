package 动态规划;

//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
// 假设每一种面额的硬币有无限个。
public class 零钱兑换2 {
    //因为硬币的数量不限，所以属于完全背包问题
    public int change(int amount, int[] coins) {
        // dp[i]表示凑够 i 的组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount ; i++) {
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
    //因为硬币的数量不限，所以属于完全背包问题
    public int change1(int amount, int[] coins) {
        int N=coins.length;
        //dp[i][j] 表示使用前i种硬币，凑够金额j的组合数
        int[][] dp = new int[N + 1][amount + 1];
        //初始化  当amount=0时，方法数为1
        for (int i = 0; i < N + 1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                //金额小于硬币大小，就不选，所以等于dp[i-1][j]
                if (j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    //因为求的是方法数量，所以应该相加。
                    // 因为使用的是同一种硬币，所以等于dp[i][j-coins[j-1]],而不是dp[i-1][j-coins[i-1]]
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[N][amount];
    }
}
