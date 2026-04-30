class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)return new ArrayList<>();
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, sb, list, map, digits);
        return list;
    }

    public void helper(int ind,StringBuilder s, List<String> list, String[] map, String digits){
        if(ind == digits.length()){
            list.add(s.toString());
            return;
        }

        String letters = map[digits.charAt(ind) - '0'];

        for(int i=0;i<letters.length();i++){
            s.append(letters.charAt(i));
            helper(ind+1, s, list, map, digits);
            s.deleteCharAt(s.length() - 1);
        }
    }
}