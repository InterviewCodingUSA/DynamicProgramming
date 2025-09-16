//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String str1 = "techinterviewzone";
        String str2 = "zoneeinterviewtech";
        longestCommonSubString(str1, str2);
    }
    public static void longestCommonSubString(String str1, String str2)
    {

        int m=str1.length();
        int n=str2.length();
        int[][] dp = new int[m+1][n+1];


        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(str1.charAt(i-1) ==str2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=0;                   // ONLY THIS CHANGE
            }
        }
        int maxLen=0;              // Now finding the max element
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
                maxLen= Math.max(maxLen,dp[i][j]);
        }
        System.out.println(maxLen);


//        System.out.println(result);
//        System.out.println((str1.substring(endpoint - result, result)));
    }

}