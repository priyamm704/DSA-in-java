class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums.length;

        for(int i=2*n-1;i >= 0;i--){
            int ind = i % n;
            
            while(!st.isEmpty() && nums[ind] >= st.peek()){
                st.pop();
            }

            if(i < n){
                ans[ind] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[ind]);
        }
        return ans;
    }
}