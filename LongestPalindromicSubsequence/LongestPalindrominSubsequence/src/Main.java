//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Input: s = "bbabcbcab"
//        Output: 7
//        Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
        String str = "bbabcbcab";
        System.out.println(LongestPalindromicSubSequenceDP(str));

    }

    // Returns the length of the longest palindromic subsequence in seq
    static int LongestPalindromicSubSequence(String seq, int i, int j)
    {
        // Base Case 1: If there is only 1 character
        if (i == j)
            return 1;


        // Base Case 2: If there are only 2 characters and both are same
        if (seq.charAt(i)== seq.charAt(j) && i + 1 == j)
            return 2;


        // If the first and last characters match
        if ( seq.charAt(i) == seq.charAt(j) )
            return LongestPalindromicSubSequence(seq, i + 1, j - 1) + 2;


        // If the first and last characters do not match
        return Math.max(LongestPalindromicSubSequence(seq, i, j - 1), LongestPalindromicSubSequence(seq, i + 1, j));
    }


    static int LongestPalindromicSubSequenceDP(String str)
    {
        int[][] table = new int[str.length()][ str.length()];
        for (int i = 0; i < str.length(); i++)
        {
            table[i][i] = 1;
        }
        for (int l = 2; l <= str.length(); l++)
        {
            for (int i = 0; i < str.length() - l + 1; i++)
            {
                int j = i + l - 1;
                if (l == 2 && str.charAt(i) == str.charAt(j))
                {
                    table[i][ j] = 2;
                }
                else if (str.charAt(i) == str.charAt(j))
                {
                    table[i][ j] = table[i + 1][ j - 1] + 2;
                }
                else
                {
                    table[i][j] = Math.max(table[i + 1][ j], table[i][ j - 1]);
                }
            }
        }
        return table[0][str.length() - 1];
    }

}