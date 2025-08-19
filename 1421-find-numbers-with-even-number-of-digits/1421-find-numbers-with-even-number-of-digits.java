class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        for(int val:nums){
            int digits = 0;
            while(val>0){
                val /=10;
                digits++;
            }
            if(digits % 2 == 0){
                even++;
            }
        }
        return even;
    }
}