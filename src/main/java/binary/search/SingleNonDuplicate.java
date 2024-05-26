package binary.search;

public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int res = singleNonDuplicate(nums);

        System.out.println(res); // expect 2

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        int res2 = singleNonDuplicate(nums2);
        System.out.println(res2); // expect 10
    }


    public static int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if ((mid % 2 == 0 && nums[mid] == nums[mid - 1]) || (mid % 2 == 1 && nums[mid] == nums[mid + 1])) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return nums[lo];
    }

    /*
    lo = 2, hi = 3, mid = 3
    lo = 2, hi = 3, mid = 3
    raw version
     */
//    public static int singleNonDuplicate(int[] nums) {
//        int lo = 0, hi = nums.length - 1;
//
//        while (lo < hi) {
//            int mid = lo + (hi - lo + 1) / 2;
//            // System.out.println("lo=" + lo + "  hi= " + hi + " mid= " + mid);
//            if (mid % 2 == 0) { // there are even element on left
//                if (nums[mid] == nums[mid - 1]) { // nums[mid] is in 2nd part ==> odd element remain on left => res on left
//                    hi = mid - 1;
//                } else {
//                    lo = mid;
//                }
//            } else { // there are odd elements on left
//                if (nums[mid] == nums[mid + 1]) { // nums[mid] is in 1st part ==> odd elements remain on left => res on left
//                    hi = mid - 1;
//                } else {
//                    lo = mid;
//                }
//            }
//        }
//        return nums[lo];
//    }
}
