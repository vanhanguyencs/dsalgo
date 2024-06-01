package twopointer;

/*
Find the minimum absolute difference between any element in array1 and any element in array2. Both
arrays are sorted.
input
arr1 = [-2, 5, 14, 23, 33, 60, 100]
arr2 = [-10, 10, 47, 57, 62, 66]
output
2 (from |62 - 60|)
input
arr1 = [-1000, -100, 0, 200]
arr2 = [-2000, -1500, -1400, -500, 550, 1000]
output
350 (from |200 - 550|)
 */
public class TwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {-2, 5, 14, 23, 33, 60, 100};
        int[] arr2 = {-10, 10, 47, 57, 62, 66};

        int mindiff = minDiff(arr1, arr2);
        System.out.println(mindiff);

        arr1 = new int[]{-1000, -100, 0, 200};
        arr2 = new int[]{-2000, -1500, -1400, -500, 550, 1000};
        System.out.println(minDiff(arr1, arr2));
    }

    public static int minDiff(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < arr1.length && j < arr2.length) {
            min = Math.min(min, Math.abs(arr1[i] - arr2[j]));
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
