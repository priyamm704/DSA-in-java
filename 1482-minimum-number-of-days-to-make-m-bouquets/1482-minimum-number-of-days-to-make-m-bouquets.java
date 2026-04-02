class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n)return -1;

        int low = getMin(bloomDay);
        int high = getMax(bloomDay);

        while(low <= high){
            int mid = low + (high-low) / 2;

            if(possible(bloomDay, mid,m, k)){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
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

    public static boolean possible(int[] arr, int mid, int m, int k){
        int bouquets = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= mid){
                count++;
            }else{
                bouquets += count/k;
                count = 0;
            }
        }
        bouquets += count/k;
        if(bouquets >= m) return true;
        return false;
    }
}