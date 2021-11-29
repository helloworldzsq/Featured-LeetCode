package dfs;

import java.util.ArrayList;
import java.util.List;
//给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
public class 子集 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        backtrace(nums,list,0);
        return lists;
    }

    private  void backtrace(int[] nums,List<Integer> list, int i) {
        lists.add(new ArrayList<>(list));
        for (int j = i; j <nums.length; j++) {
            list.add(nums[j]);
            //因为每个数字使用完之后不会再被使用，因此从j+1开始
            backtrace(nums,list,j+1);
            list.remove(list.size()-1);
        }
    }
}
