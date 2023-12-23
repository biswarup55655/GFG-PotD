//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Dec23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}

// } Driver Code Ends
class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        
        int threshold = n / k;

        // Using a HashMap to store the count of each element
        Map<Integer, Integer> elementCount = new HashMap<>();

        // Counting occurrences of each element in the array
        for (int num : arr) {
            elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
        }

        // Counting elements that appear more than n/k times
        int count = 0;
        for (int occurrences : elementCount.values()) {
            if (occurrences > threshold) {
                count++;
            }
        }

        return count;
    }
}
