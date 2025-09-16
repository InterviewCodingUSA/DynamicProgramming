import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(findFibRecursive(7));
        System.out.println(findFibMemoization(7, new HashMap<>()));
        System.out.println(findFibTabulated(7));
    }

    static int findFibRecursive(int n)
    {
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        if (n < 0)
            return Integer.MIN_VALUE;
        if (n <= 1)
            return n;
        else
            return findFibRecursive(n - 1) + findFibRecursive(n - 2);
    }

    static int findFibMemoization(int n, HashMap<Integer, Integer> memo)
    {
        if (!memo.containsKey(n))
        {
            if (n <= 1)
                memo.put(n, n);
            else
            {
                memo.put(n, findFibMemoization(n - 1, memo) + findFibMemoization(n - 2, memo));
            }
        }
        return memo.get(n);
    }

    public static int findFibTabulated(int n)
    {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; ++i)
        {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }





}