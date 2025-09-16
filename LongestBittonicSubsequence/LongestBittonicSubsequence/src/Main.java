//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longestBittonicSubsequence(arr));

        int[] arr1 = {12, 11, 40, 5, 3, 1};
        System.out.println(longestBittonicSubsequence(arr1));
    }



    //{1, 11, 2, 10, 4, 5, 2, 1};
    //Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
    //Input arr[] = {12, 11, 40, 5, 3, 1}
    //Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)
    static int longestBittonicSubsequence(int[] arr)
    {
        int[] lis = new int[arr.length];
        int[] lds = new int[arr.length];


        for (int i = 0; i < arr.length; i++)
        {
            lis[i] = 1;
            lds[i] = 1;
        }


        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                {
                    lis[i] = lis[j] + 1;
                }
            }
        }


        for (int i = arr.length - 2; i >= 0; i--)
        {
            for (int j = arr.length - 1; j > i; j--)
            {
                if (arr[i] > arr[j])
                {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (max < lis[i] + lds[i] - 1)
                max = lis[i] + lds[i] - 1;
        }


        return max;
    }

}