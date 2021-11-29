package dfs;

import java.util.ArrayList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
public class 全排列 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        dfs(nums, list);
        return lists;
    }
    private  void dfs(int[] nums,List<Integer> list) {
        if (list.size()==nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            dfs(nums,list);
            //撤销选择 (移除最后一个元素)
            list.remove(list.size()-1);
        }
    }
}
