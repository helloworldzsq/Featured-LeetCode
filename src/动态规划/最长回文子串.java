package 动态规划;


//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class 最长回文子串 {
    //这题没有使用动态规划，使用的暴力解法，感觉暴力比较好理解，而且没有超时
    public String longestPalindrome(String s) {
        int len=s.length();
        if (len<2)
            return s;
        int maxlen=1;
        int begin=0;
        //将字符串转换为数组
        char[] chars = s.toCharArray();
        //枚举所有长度大于2的字符子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (j-i+1>maxlen && isHunwen(chars,i,j)){
                 maxlen=j-i+1;
                 begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    //判断是否是回文数
    private boolean isHunwen(char[] chars, int i, int j) {
        while (i<j){
            if (chars[i]!=chars[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
