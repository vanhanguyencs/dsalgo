package recursive;

/*
A group of N friends are sharing a candy bar with a numbered sweetness level on each part.

For example:
n = 3 people
bar = [1, 2, 3, 3, 2, 4, 4]

If I cut the bar as: [1, 2 | 3, 3, 2 | 4, 4] // The parts are 3, 8, 8 -> I get 3
If I cut the bar as: [1, 2, 3 | 3, 2 | 4, 4] // The parts are 6, 5, 8 -> I get 5
If I cut the bar as: [1, 2, 3 | 3, 2, 4 | 4] // The parts are 6, 9, 4 -> I get 4

My friends will pick the sweetest slices (with the max totals) and I'll be left with the least slice (with the miniumum total).
What's the maximum total sweetness I could possibly get?   output 5
*/

public class SweetnessSlice {
    static int max = 0;

    public static void main(String[] args) {
        int n = 3;
        int[] bar = new int[]{1, 2, 3, 3, 2, 4, 4};

        int max = maxSlice(bar, n);
        System.out.println(max);
    }

    // find max of min
    public static int maxSlice(int[] bar, int n) {
        helper(bar, 0, n, 0, Integer.MAX_VALUE);
        return max;
    }

    // n: number of slice remaining
    // minSoFar: min sum of each slice.
    public static void helper(int[] bar, int cur, int n, int sum, int minSoFar) {
        if (n == 0) {
            System.out.println("cur: " + cur + " minsofar: " + minSoFar);
            max = Math.max(max, minSoFar);
            return;
        } else if (cur > bar.length - 1) {
            return;
        }
        sum += bar[cur];
        // continue add to current slice
        helper(bar, cur + 1, n, sum, minSoFar);

        // wrap cur slice, set up new slice
        minSoFar = Math.min( minSoFar, sum);
        helper(bar, cur + 1, n - 1, 0, minSoFar);
    }


}
