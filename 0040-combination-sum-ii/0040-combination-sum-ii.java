class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helpo(0, 0,new ArrayList<>(), candidates, target, res);
        return res;
    }

    public static void helpo(int ind,int sum,List<Integer> list,int[] arr,int target,List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind;i<arr.length;i++){

            if(i > ind && arr[i] == arr[i-1])continue;
            if(sum + arr[i] > target) break;

            list.add(arr[i]);
            helpo(i+1, sum+arr[i], list, arr, target, res);
            list.remove(list.size()-1);
        }
    }
}