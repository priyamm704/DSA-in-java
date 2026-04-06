class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m) return findMedianSortedArrays(nums2, nums1);
        int left = (n+m+1) / 2;
        int low = 0;
        int high = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int mid2 = left - mid;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid < n) r1 = nums1[mid];
            if(mid2 < m) r2 = nums2[mid2];
            if(mid-1 >= 0 ) l1 = nums1[mid-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];
            if(l1 <= r2 && l2 <= r1){
                if((n+m)%2 == 1){
                    return Math.max(l1, l2);
                }else{
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }else if(l1 > r2) high = mid-1;
            else low = mid+1;
        }
        return 0.0;
    }
}