//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Jan6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        long sum =0;
        int maxNum = (int)Math.max(b,2);
        int [] smallestPrimeFactor = sieve(maxNum);
        for(long i = a;i<=b;i++){
            sum += sumOfPowersForNumber(i,smallestPrimeFactor);
        }
        return sum;
    }
    public static long sumOfPowersForNumber(long num,int []smallestPrimeFactor){
        long count =0;
        while(num>1){
            int power =0;
            int primeFactor = smallestPrimeFactor[(int)num];
            while(num%primeFactor == 0){
                num/=primeFactor;
                power++;
            }
            count+=power;
        }
        return count;
    }
    public static int[] sieve(int n){
        int []smallestPrimeFactor = new int [n+1];
        for(int i=2;i<=n;i++){
            smallestPrimeFactor[i] = i;
        }
        for(int p=2;p*p<=n;p++){
            if(smallestPrimeFactor[p] == p){
                for(int i =p*p;i<=n;i+=p){
                    if(smallestPrimeFactor[i] == i){
                        smallestPrimeFactor[i] = p;
                    }
                }
            }
        }
        return smallestPrimeFactor;
    }
}
        