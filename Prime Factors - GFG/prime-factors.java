//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        // code here
      ArrayList<Integer> list = new ArrayList<>();
      for(int i = 1 ; i <= N; i++)
        {
           
            if(N %i == 0)
            {
               if(isprime(i))
               {
                   list.add(i);
               }
               
                
            }
        }
                
        int[] result = new int[list.size()];
        
        for(int i=0; i<list.size();i++){
            result[i] = list.get(i);
        }
        
        return result;
    
    }
    static boolean isprime(int r)
    {
        if(r == 1)
        return false;
        else if(r == 2)
        return true;
        else
        {
        for(int i = 2 ; i <= r/2; i++)
        {
            if(r%i == 0)
            return false;
        }
        }
        return true;
    }
}