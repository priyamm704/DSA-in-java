import java.util.*;

class Solution {

    public long subArrayRanges(int[] nums) {
        return sumOfMaximums(nums) - sumOfMinimums(nums);
    }

    public static long sumOfMaximums(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;

            total += (long) arr[i] * left * right;
        }

        return total;
    }

    public static long sumOfMinimums(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            total += (long) arr[i] * left * right;
        }

        return total;
    }

    public static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }

    public static int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pge;
    }

    public static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public static int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }
}