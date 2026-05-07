class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for(int i=0;i<=n;i++){
            int curr = (i == n ? 0 : heights[i]);
            while(!st.isEmpty() && heights[st.peek()] > curr){
                int height = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int area = height * (i - left - 1);
                max = Math.max(max, area);
            }
            st.push(i);
        }
        return max;
    }
}