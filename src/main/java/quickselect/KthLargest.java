package quickselect;

import java.util.Random;

public class KthLargest {
    static Random rand = new Random();
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int res = findKthLargest(nums, 2);
        System.out.println(res); // expect 5
    }

    // k largest = len - k + 1 smallest
    // k = 2 -> 6-2+1 = 5th smallest
    // Time complexity:
    // worst case: O(n^2)
    // avg case : O(n + n/2 + n/4 + ..) = O(2n) = O(n)
    // Space complexity: O(1)
    // If we use min heap: O(n log (k)) + space O(k)
    // Heap is used when data is dynamic like data stream
    // Quick select is used when data nums is static
    public static int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k + 1;
        while (lo <= hi) {
            int pivotIndex = partition(nums, lo, hi);
            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            } else if (pivotIndex < k - 1) {
                lo = pivotIndex + 1;
            } else {
                hi = pivotIndex - 1;
            }
        }
        // k is out of range
        return 0;
    }

    public static int partition(int[] nums, int lo, int hi) {
        int pivotIdx = rand.nextInt((hi - lo) + 1) + lo;
        swap(nums, pivotIdx, lo);
        int pivot = nums[lo];
        int i = lo, j = hi;
        while (i <= j) {
            if (nums[i] > pivot && nums[j] < pivot) {
                swap(nums, i, j);
            } else if (nums[i] <= pivot) {
                i++;
            } else {
                j--;
            }
        }
        swap(nums, lo, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
