package recursive;

public class CoinChange {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        helper(coins, 0, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void helper(int[] coins, int cur, int amount, int count) {
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        } else if (amount < 0 || cur > coins.length - 1) {
            return;
        }
        helper(coins, cur, amount - coins[cur], count + 1);
        helper(coins, cur + 1, amount, count + 1);
    }


}
