class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,new ArrayList<>(),nums, res);
        return res;
    }

    public static void helper(int ind, List<Integer> list, int[] nums, List<List<Integer>> res){
        
        res.add(new ArrayList<>(list));

        for(int i=ind;i<nums.length;i++){

            if(i > ind && nums[i] == nums[i-1])continue;

            list.add(nums[i]);
            helper(i+1,list,nums,res);
            list.remove(list.size()-1);
        }
    }
}