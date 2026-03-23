class Solution {
    public int[] rearrangeArray(int[] arr) {
        int[] sortedArr = new int[arr.length];
        int positiveIndex=0, negativeIndex=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){
                sortedArr[negativeIndex] = arr[i];
                negativeIndex += 2;
            }else{
                sortedArr[positiveIndex] = arr[i];
                positiveIndex += 2;
            }
        }
        return sortedArr;
    }
}