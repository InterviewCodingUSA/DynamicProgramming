//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(CoinChangeNumWays(coins, 4));

        int[] Coins = {2,5,3,6};
        System.out.println(CoinChangeNumWays(Coins, 10));
    }

    // Sum = 4 coins = {1,2,3} 4 ways
    // Sum = 10 Coins = {2,5,3,6} 5 solution
    static int CoinChangeNumWays(int[] coins, int total)
    {int n = coins.length;

        // 2d dp array where n is the number of coin
        // denominations and sum is the target sum
        int[][] dp = new int[n + 1][total + 1];

        // Represents the base case where the target sum is 0,
        // and there is only one way to make change: by not
        // selecting any coin
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= total; j++) {

                // Add the number of ways to make change without
                // using the current coin
                dp[i][j] += dp[i - 1][j];

                if ((j - coins[i - 1]) >= 0) {

                    // Add the number of ways to make change
                    // using the current coin
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][total];
    }

}