class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int preffix = 1;
        int suffix = 1;
        for(int i=0;i<nums.length;i++){
            if(preffix == 0) preffix = 1;
            if(suffix == 0) suffix = 1;
            preffix *= nums[i];
            suffix *= nums[nums.length-i-1];
            max = Math.max(max, Math.max(preffix, suffix));
        }
        return max;
    }
}