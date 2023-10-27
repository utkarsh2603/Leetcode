//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
        if(n==0) return 0;
        
        // we can only add the bit size of the number of 1s
        // so only find the max bit size of the number and do such loop
        int size = (int)Math.ceil(Math.log(n) / Math.log(2));
        
        for(int i=n-size; i<=n; i++){
            if( i + countSetBits(i) == n ) return 0;
        }
        return 1;
    }
    
    public int countSetBits(int n){
        int ct = 0;
        while(n > 0){
            n &= (n-1);
            ct++;
        }
        return ct;
    }
}