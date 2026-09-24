class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            while (nums[i] > 0) {
                int rem = nums[i] % 10;

                nums[i] /= 10;
                sum += rem;

            }
            if (i == sum) {
                return i;
            }
        }
        return -1;
    }
}