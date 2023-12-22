//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Dec22{
    public static int[] input(BufferedReader br, int n) throws IOException{
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);        
        return a;
    }    
    public static void print(int[] a){
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }    
    public static void print(ArrayList<Integer>a){
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}
class GFG{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){            
            int N; 
            N = Integer.parseInt(br.readLine());
            int[] S = Dec22.input(br, N);
            int[] F = Dec22.input(br, N);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);            
            Dec22.print(res);
        }
    }
}
class Meetings{
    int start,end,index;
    public Meetings(int start,int end,int index){
        this.start = start;
        this.end =end;
        this.index=index;
    }
}
class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<Integer> result= new ArrayList<>();
        ArrayList<Meetings> meeting= new ArrayList<>();
        for(int i=0;i<N;i++){
            meeting.add(new Meetings(S[i],F[i],i+1));
        }
        
        meeting.sort(Comparator.comparingInt((Meetings m) -> m.end).thenComparingInt(m -> m.start));
        
        result.add(meeting.get(0).index);
        int prevFinishTime =meeting.get(0).end;
        for(int i =1;i<N;i++){
            if(meeting.get(i).start > prevFinishTime){
                result.add(meeting.get(i).index);
                prevFinishTime = meeting.get(i).end;
            }
        }
        
        Collections.sort(result);
        return result;
    }
}