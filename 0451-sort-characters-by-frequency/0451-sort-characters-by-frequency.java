class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for(char c : map.keySet()){
            int freq = map.get(c);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(c);
        }

        StringBuilder result = new StringBuilder();
        for(int i = bucket.length-1;i>=0;i--){
            if(bucket[i] != null){
                for(char c : bucket[i]){
                    int freq = i;
                    while(freq-- > 0){
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}