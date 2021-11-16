package 动态规划;

import java.util.Arrays;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
// 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
public class 最长递增子序列 {

    public  int lengthOfLIS(int[] nums) {
        if (nums.length<1)
            return 0;
        //dp[i]表示 以nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        int res=1;
        //给数组赋值为1
        Arrays.fill(dp,1);
        for (int i = 1; i <nums.length; i++) {
            //寻找i之前比i小的值
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
