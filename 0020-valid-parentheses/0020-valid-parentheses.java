class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                dq.push(c);
            } else {
                if(dq.isEmpty())return false;

                if(c == ')' && dq.pop() != '(')return false;
                if(c == '}' && dq.pop() != '{')return false;
                if(c == ']' && dq.pop() != '[')return false;
            }
        }
        return dq.isEmpty();
    }
}
