//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        maximumSubSequenceStringInTwoString();
    }

    public static void maximumSubSequenceStringInTwoString()
    {
        int m, n;
        char[] str1 = { 'a', 'b', 'c', 'd', 'g', 'h' };
        char[] str2 = { 'a', 'e', 'd', 'f', 'h', 'r' };
        m = str1.length;
        n = str2.length;
        //StringBuilder subs = new StringBuilder();


        int[][] Lcs = new int[m + 1][ n + 1];


        for (int i = 0; i <= str1.length; i++)
            for (int j = 0; j <= str2.length; j++)
            {
                if (i == 0 || j == 0)
                    Lcs[i][ j] = 0;
                    else if (str1[i - 1] == str2[j - 1])
            {
                Lcs[i][ j] = Lcs[i - 1][ j - 1] + 1;
                //subs.Append(str1[i-1]);
            }
            else
                Lcs[i][ j] = Math.max(Lcs[i - 1][ j], Lcs[i][ j - 1]);
            }

        System.out.println((Lcs[m][ n]));
    }

}