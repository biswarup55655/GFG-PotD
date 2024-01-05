//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Jan5
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        long MOD = 1000000007;
        long dp[] = new long[N+1];
        dp[0] = 1;
        dp[1]=1;
        for(int i=2;i<=N;i++){
            dp[i]= (dp[i-1]+dp[i-2])%MOD;
        }
        long res = (dp[N]+dp[N-1])%MOD;
        res = (res * res)%MOD;
        return (int)res;
    }
}