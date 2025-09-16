//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(catalan(5));

        System.out.println(catalanDP(5));
    }

    //The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
    // A recursive function to find
    // nth catalan number
    static int catalan(int n)
    {
        int res = 0;


        // Base case
        if (n <= 1)
        {
            return 1;
        }
        for (int i = 0; i < n; i++)
        {
            res += catalan(i)
                    * catalan(n - i - 1);
        }
        return res;
    }


    static int catalanDP(int n)
    {
        // Table to store results of subproblems
        int[] catalan = new int[n + 1];


        // Initialize first two values in table
        catalan[0] = catalan[1] = 1;


        // Fill entries in catalan[] using recursive formula
        for (int i = 2; i <= n; i++)
        {
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i - j - 1];
        }


        // Return last entry
        return catalan[n];
    }




}