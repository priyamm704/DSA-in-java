class Solution {
    public int maximalRectangle(char[][] matrix) {

        if(matrix.length == 0)return 0;

        int max = 0;
        int n = matrix[0].length;
        int[] heights = new int[n];

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<n;j++){

                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j] += 1;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

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