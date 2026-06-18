class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];

        Arrays.fill(last, -1);

        int i = 0;
        int maxLen = 0;

        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            i = Math.max(i, last[c] + 1);

            last[c] = j;

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}