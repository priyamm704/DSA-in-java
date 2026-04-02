class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);

        while(low <= high){
            int mid = low + (high - low) / 2;

            long totalHours = findTotalHours(piles, mid, h);
            if(totalHours <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static long findTotalHours(int[] arr,int hour,int h){
        long totalHours = 0;

        for(int i=0;i<arr.length;i++){
            totalHours += (arr[i] + hour - 1) / hour;
            if(totalHours > h) return totalHours;
        }
        return totalHours;
    }

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}