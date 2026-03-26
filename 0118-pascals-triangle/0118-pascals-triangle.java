class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(generateRow(i));
        }
        return list;
    }

    public static List<Integer> generateRow(int row){
        List<Integer> list = new ArrayList<>();
        int res = 1;
        list.add(res);
        for(int i=1;i<=row;i++){
            res *= (row-i+1);
            res = res / i;
            list.add(res);
        }
        return list;
    }
}