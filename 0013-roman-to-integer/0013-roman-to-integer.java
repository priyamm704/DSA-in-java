class Solution {
    public int romanToInt(String s) {
        int sum = 0;

        for(int i=0;i<s.length();i++){
            int curr = getValue(s.charAt(i));

            if(i < s.length()-1 && curr < getValue(s.charAt(i+1))) {
                sum -= curr;
            }else{
                sum += curr;
            }
        }
        return sum;
    }

    public int getValue(char ch) {
        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;
        return 1000; // M
    }
}