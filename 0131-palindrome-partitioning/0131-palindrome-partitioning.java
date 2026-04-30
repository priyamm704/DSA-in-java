class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(0, list, s, res);
        return res;
    }

    public static void helper(int ind,List<String> list ,String s,List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind;i<s.length();i++){
            if(isPalindrome(s, ind, i)){
                list.add(s.substring(ind, i+1));
                helper(i+1,list,s,res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}