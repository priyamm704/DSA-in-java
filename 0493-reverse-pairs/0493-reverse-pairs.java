class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    public static int mergeSort(int[] arr,int start,int end){
        //devide devide devide till it becomes equal
        //merge into sorted manner;
        int count = 0;
        if(start >= end) return count;
        int mid = (start + end)/2;
        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid+1, end);
        count += mergeCountPairs(arr,start,mid,end);
        merge(arr,start,mid,end);
        return count;
    }

    public static void merge(int[] arr,int start,int mid,int end){
        int left = start;
        int right = mid+1;

        int[] temp = new int[end-start+1];

        int k=0;
        while( left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[k] = arr[left];
                left++;
                k++;
            }
            else if(arr[right] < arr[left]){
                temp[k] = arr[right];
                right++;
                k++;
            }
        }
        while(left <= mid){
            temp[k] = arr[left];
            left++;
            k++;
        }
        while(right <= end){
            temp[k] = arr[right];
            right++;
            k++;
        }

        for(int i=0;i<temp.length;i++){
            arr[start+i] = temp[i];
        }
    }

    public static int mergeCountPairs(int[] arr,int start,int mid, int end){
        int i = start;
        int j = mid+1;
        int count = 0;
        while( i <= mid ){
            while( j <= end && arr[i] > 2L * arr[j]){
                j++;
            }
            count += (j-(mid+1));
            i++;
        }
        return count;
    }

}