class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        boolean isNeg = exp<0;
        if(isNeg){
            exp = -exp;
        }
        double result = helper(x,exp);
        if(isNeg){
            return 1/result;
        }
        return result;
    }

    public static double helper(double x,long exp){
        if(exp == 0)return 1;
        double half = helper(x, exp/2);
        if(exp % 2 == 1){
            return half*half*x;
        }else{
            return half*half;
        }
    }
}