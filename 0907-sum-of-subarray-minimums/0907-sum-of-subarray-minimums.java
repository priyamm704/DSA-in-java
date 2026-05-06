class Solution {

    public static int[] findNse(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public static int[] findPsee(int[] arr){
        int[] psee = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        return psee;
    }

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int[] nse = findNse(arr);
        int[] psee = findPsee(arr);

        long total = 0;

        for(int i = 0; i < arr.length; i++){
            long left = i - psee[i];
            long right = nse[i] - i;

            long contribution = (left * right) % MOD;
            contribution = (contribution * arr[i]) % MOD;

            total = (total + contribution) % MOD;
        }

        return (int) total;
    }
}