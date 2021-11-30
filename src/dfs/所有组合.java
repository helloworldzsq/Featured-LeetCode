package dfs;

import java.util.ArrayList;
import java.util.List;


//给定数字 n 和 k， 返回包含k个数字 1-n范围的所有组合
public class 所有组合 {

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(lists,list,k,1,n);
        return lists;
    }
    private void backtrace(List<List<Integer>> lists, List<Integer> list, int k, int i,int n) {
        if (list.size()==k){
            lists.add(new ArrayList<>(list));
        }
        for (int j = i; j <=n; j++) {
            list.add(j);
            //j+1 排除已选择的数
            backtrace(lists,list,k,j+1,n);
            list.remove(list.size()-1);
        }
    }
}
