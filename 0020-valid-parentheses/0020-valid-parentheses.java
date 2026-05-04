class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                dq.push(c);
            } else {
                if(dq.isEmpty())return false;

                char top = dq.pop();
                if((c == ')' && top != '(') ||
                  (c == '}' && top != '{') ||
                  (c == ']' && top != '['))return false;
            }
        }
        return dq.isEmpty();
    }
}
