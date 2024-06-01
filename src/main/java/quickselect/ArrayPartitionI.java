package quickselect;

import java.util.Arrays;

public class ArrayPartitionI {
    public static void main(String[] args) {
        int[] nums = new int[]{15, -1, 12, 4, 7, 11, 9, 2, 20};
        int pivot = 9;
        arraypartition(nums, pivot);

        for(int x: nums){
            System.out.print(x + " ");
        }
    }

    public static void arraypartition(int[] nums, int pivot) {
        swap(nums, 0, 6);
        int i = 1, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] > pivot && nums[j] < pivot) {
                swap(nums, i, j);
            } else if (nums[i] <= pivot) {
                i++;
            } else {
                j--;
            }
        }
        swap(nums, 0, j);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
