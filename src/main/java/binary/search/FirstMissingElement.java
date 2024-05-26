package binary.search;

public class FirstMissingElement {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, -1, 0, 2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 16, 17, 18};

        int res = firstMissingNumber(nums);
        System.out.println(res); // expect output = 1
    }

    public static int firstMissingNumber(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int diff = nums[1] - nums[0];

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            System.out.println("lo=" + lo + " hi= " + hi + " mid= " + mid);
            if (nums[0] + mid * diff == nums[mid]) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo] + diff;
    }
}
