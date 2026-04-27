class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int x = 1 << nums.length;
        for(int i=0;i<x;i++){
            List<Integer> miniList = new ArrayList<>();
            for(int j = 0;j<nums.length;j++){
                if((i & (1 << j)) != 0){
                    miniList.add(nums[j]);
                }
            }
            list.add(miniList);
        }
        return list;
    }
}