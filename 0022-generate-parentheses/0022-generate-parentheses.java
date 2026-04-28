class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0,0,n,"",res);
        return res;
    }

    public static void helper(int open,int close,int n,String curr,List<String> res){
        if(curr.length() == 2*n){
            res.add(curr);
            return;
        }

        if(open < n){
            helper(open+1,close,n,curr+"(",res);
        }

        if(close < open){
            helper(open,close+1,n,curr+")",res);
        }
    }
}