//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class dec29
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// } Driver Code Ends
//User function Template for Java

class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        // Your Code Here 
        if( n == k ){
            return 1;
        }
        if(n%k !=0){
            return 0;
        }
        HashMap<String, Integer> m = new HashMap<>();
        for(int i=0;i<n;i+=k){
            m.put(s.substring(i,k+i),m.getOrDefault(s.substring(i,k+i),0)+1);
        }
        if(m.size()==1){
            return 1;
        }
        if(m.size()!=2){
            return 0;
        }
        int freq=0;
        for(int i : m.values()){
            freq = i;
            break;
        }
        if((freq == 1) || freq == (n/k - 1)){
            return 1;
        }
        return 0;
    }
}
