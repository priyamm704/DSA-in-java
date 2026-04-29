class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0, 0, list, candidates, target, res);
        return res;
    }
    public static void helper(int ind,int sum,List<Integer> list,
                                int[] arr,int target,List<List<Integer>> res){
        if(sum > target)return;
        if(ind == arr.length){
            if(sum == target){
                res.add(new ArrayList<>(list));
                return;
            }
            return;
        }

        list.add(arr[ind]);
        helper(ind, sum+arr[ind], list, arr, target, res);
        list.remove(list.size()-1);
        helper(ind+1, sum, list, arr, target, res);
    }
}