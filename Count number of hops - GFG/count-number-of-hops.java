//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    static long find(int n,long mod,long dp[]){
        if(n==0)return dp[n]=1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        
        return dp[n]=(find(n-1,mod,dp)+find(n-2,mod,dp)+find(n-3,mod,dp))%mod;
    }
    
    
  
    static long countWays(int n)
    {
        long dp[]=new long[n+1];
        Arrays.fill(dp,-1);
        
        long mod=1000000007L;
        return find(n,mod,dp)%mod;
    }
    
}