class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> s = new ArrayDeque<>();

        for(int a : asteroids){

            boolean alive = true;

            while(alive && a < 0 && !s.isEmpty() && s.peek() > 0){
                if(s.peek() < -a){
                    s.pop();
                }else if(s.peek() == -a){
                    s.pop();
                    alive = false;
                }else{
                    alive = false;  
                }
            }

            if(alive){
                s.push(a);
            }
        }

        int[] res = new int[s.size()];
        for(int i=res.length-1;i >= 0;i--){
            res[i] = s.pop();
        }

        return res;
    }
}