//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Jan9
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> indices = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        for(int i = 0; i<=n-m ; i++){
            int j;
            for(j=0;j<m;j++){
                if(txt.charAt(i+j)!= pat.charAt(j)){
                    break;
                }
            }
            if(m == j){
                indices.add(i+1);
            }
        }
        return indices;
    }
}