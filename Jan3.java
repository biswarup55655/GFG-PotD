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
        int res = S.length();
        boolean flag = false;
        int charZero =-1,charOne =-1,charTwo=-1;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='0'){
                charZero = i;
            }else if(S.charAt(i)=='1'){
                charOne = i;
            }else{
                charTwo = i;
            }
            if(charZero!=-1 && charOne !=-1 && charTwo!=-1){
                flag = true;
                res = Math.min(res,1+i - (Math.min(charZero,Math.min(charOne,charTwo))));
            }
        }
        if(flag){
            return res;
        }
        return -1;
    }
}
