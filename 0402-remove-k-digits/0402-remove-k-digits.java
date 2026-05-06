class Solution {
    public String removeKdigits(String num, int k) {

        if(k == num.length())return "0";

        Deque<Character> s = new ArrayDeque<>();

        for(char c : num.toCharArray()){
            while(!s.isEmpty() && k > 0 && s.peek() > c){
                s.pop();
                k--;
            }
            s.push(c);
        }

        while(!s.isEmpty() && k > 0){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        sb.reverse();

        int i=0;
        while(i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }

        String res = sb.substring(i);

        return res.isEmpty() ? "0" : res;
    }
}