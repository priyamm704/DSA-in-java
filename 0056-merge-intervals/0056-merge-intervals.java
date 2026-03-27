class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(list.size() == 0 || start > list.get(list.size()-1)[1]){
                list.add(new int[]{start, end});
            }else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], end);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}