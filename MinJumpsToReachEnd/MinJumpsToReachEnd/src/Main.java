//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 2, 1, 4, 6 };
        int[] result = new int[arr.length];
        System.out.println( MinJumps(arr, result) );
    }

    static int MinJumps(int[] arr, int[] result)
    {
        int[] jumps = new int[arr.length];
        jumps[0] = 0;


        for (int i = 1; i < arr.length; i++)
            jumps[i] = Integer.MAX_VALUE;


        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j] + j >= i)// check if we can make the jump
                {
                    if (jumps[i] > jumps[j] + 1)
                    {
                        result[i] = j;
                        jumps[i] = jumps[j] + 1;
                    }
                }
            }
        }
        return jumps[jumps.length - 1];
    }



}