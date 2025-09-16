//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s1="GEEXSFRGEEKKS", s2="GEEKSFORGEEKS";
        System.out.println( EditDistanceRecursive(s1,s2, s1.length(),s2.length()) );
        System.out.println( EditDistance(s1,s2) );
    }

    static int EditDistanceRecursive(String str1, String str2, int m, int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0) return n;


        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;


        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return EditDistanceRecursive(str1, str2, m - 1, n - 1);


        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min(EditDistanceRecursive(str1, str2, m, n - 1), // Insert
                EditDistanceRecursive(str1, str2, m - 1, n), // Remove
                EditDistanceRecursive(str1, str2, m - 1, n - 1) // Replace
        );


    }
    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }
    // Saturday Sunday
    static int EditDistance(String str1, String str2)
    {
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];


        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][ 0] = i;
        }
        for (int i = 0; i < matrix[0].length; i++)
        {
            matrix[0][i] = i;
        }


        for (int i = 1; i <= str1.length(); i++)
        {
            for (int j = 1; j <= str2.length(); j++)
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    // If last characters are same, ignore last char
                    // and recur for remaining string
                    matrix[i][ j] = matrix[i - 1][ j - 1];
                }
                else
                {
                    matrix[i][ j] = 1 + Math.min(matrix[i - 1][ j - 1]/* replace */,
                    Math.min(matrix[i - 1][ j]/*Remove */, matrix[i][ j - 1] /*Insert */ ));
                }
            }


        }


        return matrix[str1.length()][ str2.length()];
    }

}