package twopointer;

/*
Given two sorted arrays Alice and Bob, and a target number. Find a pair of
elements that Alice[i] - Bob[k] == target. Return null if the pair doesn't exist.
Input
Alice = [2, 5, 7, 8, 14]
Bob = [1, 6, 10, 15]
target = 2
Expected output
[8, 6]
Input
Alice = [2, 5, 7, 8, 14]
Bob = [1, 6, 10, 15]
target = -10
Expected output
[5, 15]
 */
public class TwoPointer {
    public static void main(String[] args) {
        int[] a = {2, 5, 7, 8, 14};
        int[] b = {1, 6, 10, 15};
        int[] res = findPair(a, b, 2);
        System.out.println(res[0] + " " + res[1]);
    }

    /*
    Brute force: O(m*n)
    Better: O(log(m) * n) or O(m *log(n))
    Two pointer: O(m + n)
     */
    public static int[] findPair(int[] a, int[] b, int target) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int diff = a[i] - b[j];
            if (diff == target) {
                return new int[]{a[i], b[j]};
            } else if (diff < target) {
                i++; // increase i to increase diff
            } else {
                j++; // increase j to decrease diff
            }
        }
        return new int[]{0, 0};
    }
}
