class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int i = 0;
        int maxLength = 0;

        for (int j = 0; j < s.length(); j++) {

            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(s.charAt(j));

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}