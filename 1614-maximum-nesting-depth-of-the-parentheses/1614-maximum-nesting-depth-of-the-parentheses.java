class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                depth++;
            }else if(s.charAt(i) == ')'){
                maxDepth = Math.max(maxDepth, depth);
                depth--;
            }
        }
        return maxDepth;
    }
}