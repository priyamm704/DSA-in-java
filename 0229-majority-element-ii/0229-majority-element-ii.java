class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //Moore's Algorithm
        int n = nums.length/3;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(count1 == 0 && ele2 != nums[i]){
                ele1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0 && ele1 != nums[i]){
                ele2 = nums[i];
                count2 = 1;
            }
            else if(nums[i] == ele1)count1++;
            else if(nums[i] == ele2)count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(ele1 == nums[i])count1++;
            else if(ele2 == nums[i])count2++;
        }
        if(count1 > n) list.add(ele1);
        if(count2 > n) list.add(ele2);
        return list;
    }
}