class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, 0, new ArrayList<>(), k, n, res);
        return res;
    }

    public static void helper(int start,int sum,List<Integer> list,int k,int target,List<List<Integer>> res){
        if(sum > target)return;
        if(list.size() == k){
            if(sum == target){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i=start;i<=9;i++){
            if(sum + i > target) break;

            list.add(i);
            helper(i+1, sum+i, list, k, target, res);
            list.remove(list.size() -1);
        }
    }
}