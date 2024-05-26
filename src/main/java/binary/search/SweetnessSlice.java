package binary.search;

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

Time complexity: O(n * log(sum(bar)) = O(n) because O(log(sum(bar)) is constant.
if sum(bar) is an integer, max value is 2^64 => O(log(sum(bar)) ~ O(64) which is constant.
*/
public class SweetnessSlice {
    public static void main(String[] args) {
        int n = 3;
        int[] bar = new int[]{1, 2, 3, 3, 2, 4, 4};

        int max = maxSlice(bar, n);
        System.out.println(max);
    }

    public static int maxSlice(int[] bar, int n) {
        int lo = 0, hi = sum(bar) / n;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (isMidAchievable(bar, mid, n))
                lo = mid;
            else
                hi = mid - 1;
        }
        return lo;
    }

    public static boolean isMidAchievable(int[] bar, int mid, int n) {
        int currentSum = 0;
        int count = 0;

        for (int s : bar) {
            currentSum += s;
            if (currentSum >= mid) {
                count++;
                currentSum = 0;
            }
        }

        return count >= n;
    }

    public static int sum(int[] bar) {
        int sum = 0;
        for (int x : bar) {
            sum += x;
        }
        return sum;
    }

}
