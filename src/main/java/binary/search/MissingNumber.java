package binary.search;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {5, 7, 11, 13};
        System.out.println(missingNumber(nums)); // expect 9

        nums = new int[]{15, 13, 12};
        System.out.println(missingNumber(nums)); // expect 14

    }

    public static int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (arr[0] + mid * diff == arr[mid]) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return arr[lo] + diff;
    }
}
