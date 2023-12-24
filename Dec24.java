//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Dec24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}
class Stock{
    int price,day;
    Stock(int price,int day){
        this.price=price;
        this.day=day;
    }
}
class returnmaxstock implements Comparator<Stock>{
    public int compare(Stock a,Stock b){
        return Integer.compare(a.price,b.price);
    }
}
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        ArrayList<Stock> stocks = new ArrayList<>();
        for(int i=0;i<n;i++){
            stocks.add(new Stock(price[i],i+1));
        }
        Collections.sort(stocks,new returnmaxstock());
        int res=0;
        for(int i=0;i<n;i++){
            int count = Math.min(stocks.get(i).day,k/stocks.get(i).price);
            res+=count;
            k-=count*stocks.get(i).price;
        }
        return res;
    }
}