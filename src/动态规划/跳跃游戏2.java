package 动态规划;

import java.util.Arrays;

public class 跳跃游戏2 {
    public int jump(int[] nums){
        //dp[i] 表示到达i所需的最少步数
        //初始状态 dp[0] = 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,n+1);
        dp[1] = 0;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                if (j+nums[j]>=i){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n];
    }
}
