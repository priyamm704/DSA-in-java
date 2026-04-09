class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        int i=0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j) == ' '){
                if(i < j){
                result.insert(0, s.substring(i, j));
                result.insert(0, " ");
                i = j+1;
                while(s.charAt(i) == ' ' && i < s.length()){
                    i++;
                }
            }
            }
        }
        result.insert(0, s.substring(i));
        return result.toString();
    }
}