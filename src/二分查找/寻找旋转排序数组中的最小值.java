package 二分查找;

public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int left=0,right = nums.length-1;
        //循环结束条件 left==right，此时区间中还有一个值，返回left，right都可
        while (left < right){
            int mid = left + (right-left)/2;
            //mid可能是最小值，所以right不能等于 mid-1。 例子：（1,2,3,4,5）
            if (nums[mid]<nums[right]){
                right = mid;
            }
            // 在这种情况下，mid不可能是最小值
            else
                left = mid+1;
        }
        return nums[left];
    }
}
