//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        System.out.println(longestIncreasingSubSequence(arr));
    }
//    Input  : arr[] = {3, 10, 2, 1, 20}
//    Output : Length of LIS = 3
//    The longest increasing subsequence is 3, 10, 20 */
    static int longestIncreasingSubSequence(int[] arr)
    {
        int[] lis = new int[arr.length];
        for (int i = 0; i < lis.length; i++)
            lis[i] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                {
                    lis[i] = lis[j] + 1;
                    if (max < lis[i])
                        max = lis[i];
                }
            }
        }
        return max;
    }

}