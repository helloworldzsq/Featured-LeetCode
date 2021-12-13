package 双指针;

import java.util.ArrayList;
import java.util.List;

//力扣 第986题 https://leetcode-cn.com/problems/interval-list-intersections/
public class 区间交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        List<int[]> list = new ArrayList<>();
        while (i<firstList.length && j<secondList.length){
               int a=firstList[i][0],b=firstList[i][1];
               int c=secondList[j][0],d=secondList[j][1];
               //没有交集的情况是c>b || a>d  所以有交集的情况是c<=b && a<=d
               if (b>=c && d>=a){
                   int m=Math.max(a,c);
                   int n=Math.min(b,d);
                   list.add(new int[]{m,n});
               }
               if (d<b)
                   j++;
               else
                   i++;
          }
        //便捷写法
       // return list.toArray(new int[list.size()][2]);
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k]=list.get(k);
        }
        return res;
    }
}
