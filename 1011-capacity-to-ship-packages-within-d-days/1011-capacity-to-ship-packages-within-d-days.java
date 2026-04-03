class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = getSum(weights);

        while(low <= high){
            int mid = low + (high-low) / 2;

            int day = getDays(weights, mid, days);
            if(day <= days){
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

    public static int getSum(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }

    public static int getDays(int[] weights,int mid,int days){
        int day = 1;
        int load = 0;
        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > mid){
                day++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return day;
    }
}