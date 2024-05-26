package binary.search;

public class KthMissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 16, 17, 18};

        int res = kthMissingNumber(nums, 3);

        /*
        output 14
        as 3, 9, 14, 15 are missing, and
        14 is the 3rd missing element
         */
        System.out.println(res);
    }

    public static int kthMissingNumber(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        int diff = nums[1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums[0] + mid * diff * k < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }


}
