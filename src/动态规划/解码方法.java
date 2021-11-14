package 动态规划;

//题目链接: https://leetcode-cn.com/problems/decode-ways/
public class 解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        //dp[i]的含义为 ：s[1,i]的解码数目
        int[] dp = new int[n+1];
       // 空字符串可以有1种解码方法，解码出一个空字符串。
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            //如果只使用第i个字符, dp[i]=dp[i-1] , 前提是第i个字符不为0
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //和第i-1个字符组合在一起使用，前提是第i-1为不是0，并且组合起来小于26
            if (i>1 && (s.charAt(i-2)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6')))
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
