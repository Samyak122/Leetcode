class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];

        long total = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            max = Math.max(max, diff[i]);
        }

        if (total <= k) {
            return 0;
        }

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long remaining = k;
        long answer = 0;

        for (int d : diff) {
            if (d > low) {
                remaining -= d - low;
                d = low;
            }
            answer += (long) d * d;
        }

        // Use leftover operations to reduce differences at level low.
        if (low > 0 && remaining > 0) {
            long count = 0;

            for (int d : diff) {
                if (d >= low) {
                    count++;
                }
            }

            answer -= remaining * (2L * low - 1);
        }

        return answer;
    }
}