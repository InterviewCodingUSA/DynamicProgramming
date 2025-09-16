//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] price =  {1, 5, 8, 9, 10, 17, 17, 20};
        // Output: 22
        System.out.println(cutRod(price, price.length) );

    }

    static int cutRod(int[] price, int n)
    {
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;


        // Recursively cut the rod in
        // different pieces and compare
        // different configurations
        for (int i = 0; i < n; i++)
            max_val = Math.max(max_val, price[i] +
                    cutRod(price, n - i - 1));


        return max_val;
    }
    /* Returns the best obtainable
    price for a rod of length n
    and price[] as prices of
    different pieces */
    static int cutRod(int[] price)
    {
        int[] max = new int[price.length + 1];
        for (int i = 1; i <= price.length; i++)
        {
            for (int j = i; j <= price.length; j++)
            {
                max[j] = Math.max(max[j], max[j - i] + price[i - 1]);
            }
        }
        return max[price.length];
    }

}