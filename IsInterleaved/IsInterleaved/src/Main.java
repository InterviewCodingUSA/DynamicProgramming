//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str1 = "AAB",  str2 = "AAC",  str3 =  "AAAABC";
        System.out.println(isInterleaved(str1, str2, str3, 0,0));
        System.out.println(isInterleaved(str1, str2, str3));
    }



    // i and j are indexes in s1 and s2 respectively
    static boolean isInterleaved(String s1, String s2, String s3,
                                 int i, int j)
    {
        int k = i + j;

        // If all strings are fully traversed
        if (i == s1.length() && j == s2.length()
                && k == s3.length())
            return true;

        // If any of the above mentioned two
        // possibilities then return true
        // otherwise return false.
        boolean a = (i < s1.length())
                && (s3.charAt(k) == s1.charAt(i))
                && isInterleaved(s1, s2, s3, i + 1, j);
        boolean b = (j < s2.length())
                && (s3.charAt(k) == s2.charAt(j))
                && isInterleaved(s1, s2, s3, i, j + 1);

        return a || b;
    }

    static boolean isInterleaved(String s1, String s2,
                                String s3)
    {
        int m = s1.length();
        int n = s2.length();

        // s3 can be an interleaving of s1 and s2 only if
        // the sum of lengths of s1 & s2 is equal to the
        // length of s3.
        if (m + n != s3.length())
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Handle the corner case where both s1 and s2 are
        // empty
        dp[0][0] = true;

        // Fill the first row (when s1 is empty)
        for (int j = 1; j <= n; ++j) {
            dp[0][j]
                    = (s2.charAt(j - 1) == s3.charAt(j - 1))
                    && dp[0][j - 1];
        }

        // Fill the first column (when s2 is empty)
        for (int i = 1; i <= m; ++i) {
            dp[i][0]
                    = (s1.charAt(i - 1) == s3.charAt(i - 1))
                    && dp[i - 1][0];
        }

        // Process all characters of s1 and s2
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int k = i + j;
                dp[i][j]
                        = (s1.charAt(i - 1) == s3.charAt(k - 1)
                        && dp[i - 1][j])
                        || (s2.charAt(j - 1)
                        == s3.charAt(k - 1)
                        && dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

}