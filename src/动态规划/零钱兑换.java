package 动态规划;
//给定不同面额的硬币 coins 和一个总金额 amount。
// 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//你可以认为每种硬币的数量是无限的。
public class 零钱兑换 {

    public  int coinChange(int[] coins, int amount) {
         //定义dp数组，dp[i]表示凑够金额i所需的最少金币数
        int[] dp = new int[amount + 1];
        dp[0]=0;
        for (int i = 1; i <dp.length ; i++) {
            //设为最大值
            dp[i]=amount+1;
        }
        //状态：金额（因为硬币数不限，所以不算状态）
        //选择：对金币进行选择
        //状态转移方程： dp[i] = dp[i-coin]+1
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i<coin)
                    continue;
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
