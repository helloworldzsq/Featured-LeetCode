package 动态规划;

//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//判断你是否能够到达最后一个位置。
public class 跳跃游戏 {
     //动态规划  思路：https://leetcode-cn.com/problems/jump-game/solution/55-tiao-yue-you-xi-dong-tai-gui-hua-jie-9vsu7/
    public boolean canJump1(int[] nums) {
        //dp[i]表示在下标i处能跳跃的最大值
        int a = nums[0];   //dp[i-1]
        int b = 0;    //dp[i]
        for (int i = 1; i < nums.length; i++) {
            if (a==0)
               return false;
            b = Math.max(a-1,nums[i]);
            a = b;
        }
        return true;
    }
}
