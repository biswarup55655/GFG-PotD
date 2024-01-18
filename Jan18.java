//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Jan18 {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (gallery[i] != -1) {
                intervals[i][0] = Math.max(0, i - gallery[i]);
                intervals[i][1] = Math.min(n - 1, i + gallery[i]);
            }
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxEnd = new PriorityQueue<>(Comparator.reverseOrder());
        int sprinklers = 0, i = 0, start = 0;

        while (start < n) {
            while (i < n && intervals[i][0] <= start) {
                maxEnd.offer(intervals[i][1]);
                i++;
            }
            if (maxEnd.isEmpty() || maxEnd.peek() < start) {
                return -1;
            }
            sprinklers++;
            start = maxEnd.poll() + 1;
        }
        return sprinklers;
    }
}
