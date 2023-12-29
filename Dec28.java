//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Dec28{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends
class Solution{
    static boolean match(String wild, String pattern)
    {
        // code here
        int m = wild.length();
        int n = pattern.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        for(int i = 1;i<=m;i++){
            if(wild.charAt(i-1) == '*' && dp[0][i-1]){
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (wild.charAt(i - 1) == pattern.charAt(j - 1) || wild.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (wild.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}