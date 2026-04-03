class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);

        while(low <= high){
            int mid = low + (high - low) / 2;

            int ciel = getCiels(nums, mid, threshold);
            if(ciel <= threshold){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int getCiels(int[] nums, int mid, int threshold){
        int ciel = 0;
        for(int i=0;i<nums.length;i++){
            ciel += ((nums[i] + mid - 1) / mid);
            if(ciel > threshold) return ciel;
        }
        return ciel;
    }
}