class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            int j = i + 1;
            int k = arr.length - 1;

            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];

                if(sum == 0){
                    set.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}