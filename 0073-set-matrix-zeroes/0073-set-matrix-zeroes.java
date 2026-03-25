class Solution {
    public void setZeroes(int[][] arr) {
        int rn = arr.length;
        int cn = arr[0].length;
        boolean col0 = false;
        for(int i=0;i<rn;i++){
            if(arr[i][0] == 0) col0 = true;
            for(int j=1;j<cn;j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        for(int i=rn-1;i>=0;i--){
            for(int j=cn-1;j>=1;j--){
                if(arr[i][0] == 0 || arr[0][j] == 0){
                    arr[i][j] = 0;
                }
            }
        }
        if(col0){
            for(int i=0;i<arr.length;i++){
                arr[i][0] = 0;
            }
        }
    }
}