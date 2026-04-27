class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor)return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0);
        long num = Math.abs((long)dividend);
        long den = Math.abs((long)divisor);
        long ans = 0;
        while(num >= den){
            int count = 0;
            while(num >= (den << (count + 1))){
                count++;
            }
            ans += (1L << count);
            num -= (den << count);
        }
        return sign ? (int)ans : (int)(-ans);
    }
}