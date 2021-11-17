package 双指针;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
// 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水

public class 盛最多水的容器 {

    //双指针法
    public int maxArea(int[] height) {
        if (height.length<2)
            return 0;
        int i=0;
        int j=height.length-1;
        int res=0;
        //短板向内移动，面积可能增大，不变，减小
        //长板向内移动，面积可能不变，减小
        while (i<j){
            if (height[i]<height[j]){
                res=Math.max(res,height[i]*(j-i));
                i++;
            }
            else{
                res=Math.max(res,height[j]*(j-i));
                j--;
            }
        }
        return res;
    }
}
