class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0;
        int currOne = 0;
        for(int val : nums){
            if(val == 1){
                currOne++;
                maxOne = Math.max(maxOne,currOne);
            }
            else{
                currOne = 0;
            }
        }
        return maxOne;
    }
}
