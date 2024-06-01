package quickselect;

public class ArrayPartitionII {
    public static void main(String[] args) {
        int[] nums = new int[]{15, -1, 12, 4, 7, 11, 9, 2, 20};
        int pivot = 9; // it's often pivot index but this one pivot value
        int pivotIndex = arraypartition(nums, pivot);
        System.out.println(pivotIndex);
    }

    public static int arraypartition(int[] nums, int pivot) {
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
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
