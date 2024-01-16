//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Jan16
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
        int dp[][] =new int [m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }else if(i<j){
                    dp[i][j]=0;
                }else if(j==1){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i/2][j-1];
                }
            }
        }
        return dp[m][n];
    }
}