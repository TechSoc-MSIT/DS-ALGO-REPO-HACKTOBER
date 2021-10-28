import java.util.Scanner;

public class longest_common_subsequence {

    static void lcs(String X, String Y, int m, int n)
    {
        int[][] L = new int[m+1][n+1];

        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        int index = L[m][n];
        int temp = index;

        char[] lcs = new char[index+1];
        lcs[index] = '\u0000'; // Set the terminating character
        int i = m;
        int j = n;
        while (i > 0 && j > 0)
        {

            if (X.charAt(i-1) == Y.charAt(j-1))
            {
                // Put current character in result
                lcs[index-1] = X.charAt(i-1);


                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }

        // Display the lcs
        System.out.print("LCS of "+X+" and "+Y+" is ");
        for(int k=0;k<=temp;k++)
            System.out.print(lcs[k]);
        System.out.println("\nlength of LCS is " + temp);
    }

    // driver function main
    public static void main (String[] args)
    {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter first string");
        String X = sc.next();

        System.out.println("Enter second String");
        String Y = sc.next();

        int m = X.length();
        int n = Y.length();
        lcs(X, Y, m, n);
    }
}
