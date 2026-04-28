class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        boolean isNeg = exp<0;
        if(isNeg){
            exp = -exp;
        }
        double result = 1;
        while(exp > 0){
            if((exp & 1) == 1){
                result *= x;
            }
            x *= x;
            exp >>= 1;
        }
        if(isNeg){
            return 1/result;
        }
        return result;
    }
}