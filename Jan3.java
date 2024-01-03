//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class Jan3 {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
         // Set a flag to check if an answer exists
        boolean flag = false;
        
        // Initialize variables to keep track of the last positions
        int lZero = -1, lOne = -1, lTwo = -1;
        
        // Initialize the answer length to be the length of the input string
        int res = S.length();
        
        // Iterate through each character in the input string
        for (int i = 0; i < res; i++) {
            // Update the last positions based on the current character
            if (S.charAt(i) == '0') {
                lZero = i;
            } else if (S.charAt(i) == '1') {
                lOne = i;
            } else {
                lTwo = i;
            }
            // Check if all three positions have been updated
            if (lZero != -1 && lOne != -1 && lTwo != -1) {
                // Set the flag to indicate that an answer exists
                flag = true;
                
                // Calculate the length of the substring and update the answer length
                res = Math.min(res,1 + i - Math.min(lZero, Math.min(lOne, lTwo)));
            }
        }
        
        // Check if an answer exists and return the final answer
        if (flag) {
            return res;
        }
        return -1;
    }
};
