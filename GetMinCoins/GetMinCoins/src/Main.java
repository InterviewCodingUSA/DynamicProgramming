//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {9,6,5,1};
        System.out.println(getMinCoins(arr, 11));
    }

    //      {9,6,5,1} total 11
    static int getMinCoins(int[] coins, int total)
    {
        int[][] dp = new int[coins.length][total + 1];

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int take = Integer.MAX_VALUE, noTake = Integer.MAX_VALUE;

                // If we take coins[i] coin
                if (j - coins[i] >= 0) {
                    take = dp[i][j - coins[i]];
                    if (take != Integer.MAX_VALUE) take++;
                }
                // not take the coin
                if (i + 1 < coins.length) noTake = dp[i + 1][j];

                dp[i][j] = Math.min(take, noTake);
            }
        }

        if (dp[0][total] != Integer.MAX_VALUE) return dp[0][total];
        return -1;
    }

}