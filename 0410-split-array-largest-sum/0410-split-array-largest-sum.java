class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int val : nums){
            low = Math.max(low, val);
            high += val;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            int countPartition = calculatePartition(nums, mid, k);
            if(countPartition <= k){
                high = mid-1;
            }else{
                low  = mid+1;
            }
        }
        return low;
    }

    public static int calculatePartition(int[] nums,int limit,int k){
        int partitions = 1;
        int units = 0;
        for(int i=0;i<nums.length;i++){
            if(units + nums[i] <= limit){
                units += nums[i];
            }else{
                partitions++;
                units = nums[i];
                if(partitions > k) return partitions;
            }
        }
        return partitions;
    }
}