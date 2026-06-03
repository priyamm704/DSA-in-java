class Solution {

    static class Ride {
        int start;
        int duration;

        Ride(int s, int d) {
            start = s;
            duration = d;
        }
    }

    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return ans;
    }

    private int solve(int[] firstStart,
                      int[] firstDur,
                      int[] secondStart,
                      int[] secondDur) {

        int m = secondStart.length;

        Ride[] rides = new Ride[m];

        for(int i = 0; i < m; i++) {
            rides[i] = new Ride(secondStart[i], secondDur[i]);
        }

        Arrays.sort(rides,
                (a, b) -> Integer.compare(a.start, b.start));

        int[] starts = new int[m];

        for(int i = 0; i < m; i++) {
            starts[i] = rides[i].start;
        }

        int[] prefixMinDuration = new int[m];
        prefixMinDuration[0] = rides[0].duration;

        for(int i = 1; i < m; i++) {
            prefixMinDuration[i] =
                    Math.min(prefixMinDuration[i - 1],
                             rides[i].duration);
        }

        int[] suffixMinFinish = new int[m];

        suffixMinFinish[m - 1] =
                rides[m - 1].start + rides[m - 1].duration;

        for(int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] =
                    Math.min(
                            suffixMinFinish[i + 1],
                            rides[i].start + rides[i].duration
                    );
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < firstStart.length; i++) {

            int finish1 =
                    firstStart[i] + firstDur[i];

            int pos = upperBound(starts, finish1);

            if(pos >= 0) {
                ans = Math.min(ans,
                        finish1 + prefixMinDuration[pos]);
            }

            if(pos + 1 < m) {
                ans = Math.min(ans,
                        suffixMinFinish[pos + 1]);
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        int ans = -1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}