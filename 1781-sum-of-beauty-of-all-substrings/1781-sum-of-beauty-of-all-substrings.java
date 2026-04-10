class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i = 0;i<s.length();i++){
            int[] freq = new int[26];
            int max = 0;
            for(int j=i;j<s.length();j++){
                int idx = s.charAt(j) - 'a';
                freq[idx]++;
                max = Math.max(max, freq[idx]);
                int min = Integer.MAX_VALUE;

                for(int f : freq){
                    if(f > 0){
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                sum += (max - min);
            }
        }
        return sum;
    }
}