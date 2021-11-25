package 动态规划;

public class 组合总和4 {
    //和兑换零钱2不同的是，顺序不同视作不同的组合
    public int combinationSum4(int[] nums, int target) {
        //dp[i] 表示 目标整数为i时的组合数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target+1; i++) {
            for (int num : nums) {
                if (num<i){
                    dp[i] = dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
