class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(2*n);
        helper(0,0,n,sb,res);
        return res;
    }

    public static void helper(int open,int close,int n,StringBuilder curr,List<String> res){
        if(curr.length() == 2*n){
            res.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append("(");
            helper(open+1,close,n,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close < open){
            curr.append(")");
            helper(open,close+1,n,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}