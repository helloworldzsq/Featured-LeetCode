package 二分查找;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
            //使用二分法找到一个值为target的坐标
            int mid=searchRangeInt(nums,target);
            if(mid==-1){
                return new int[]{-1,-1};
            }
            int m=mid-1;
            int n=mid+1;
            while (m>=0 && nums[m]==target)
                m--;
            while (n<nums.length && nums[n]==target)
                n++;
            return new int[]{m+1,n-1};
    }
    private  int searchRangeInt(int[] nums, int target) {
            int i=0;
            int j=nums.length-1;
            while (i<=j){
                int mid=i+(j-i)/2;
                if (nums[mid]>target)
                    j=mid-1;
                else if (nums[mid]<target)
                    i=mid+1;
                else
                    return mid;
            }
            //找不到的话，返回-1
            return -1;
        }
}

