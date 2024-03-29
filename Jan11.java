//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Jan11 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        int len = S.length();
        if(K == len){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int i=0;
        while(i<len){
            while(K>0 && result.length()> 0 && result.charAt(result.length()-1) > S.charAt(i)){
                result.deleteCharAt(result.length()-1);
                K--;
            }
            result.append(S.charAt(i));
            i++;
        }
        while(K>0){
            result.deleteCharAt(result.length()-1);
            K--;
        }
        int ptr=0;
        while(ptr<result.length() && result.charAt(ptr) == '0' ){
            ptr++;
        }
        result.delete(0,ptr);
        return result.length() == 0 ? "0" : result.toString();
    }
}