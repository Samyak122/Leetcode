import java.util.Random;

class Solution {
    Random random = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = low + random.nextInt(high - low + 1);

        // Move random pivot to the start
        swap(nums, low, pivotIndex);

        int p = partition(nums, low, high);

        quickSort(nums, low, p - 1);
        quickSort(nums, p + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];

        int i = low;
        int j = high;

        while (i < j) {

            while (i < high && nums[i] <= pivot) {
                i++;
            }

            while (j > low && nums[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, low, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}