class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int lowestBound = nums.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] >= target){
                high = mid-1;
                lowestBound = mid;
            }else{
                low = mid+1;
            }
        }
        return lowestBound;
    }
}