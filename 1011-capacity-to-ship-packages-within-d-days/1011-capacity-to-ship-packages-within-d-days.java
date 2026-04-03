class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int val : weights){
            low = Math.max(val, low);
            high += val;
        }

        while(low <= high){
            int mid = low + (high-low) / 2;

            int day = getDays(weights, mid);
            if(day <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static int getDays(int[] weights,int mid){
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