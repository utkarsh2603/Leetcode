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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        int a[]=new int[n+1];
        int k=1;
        for(int i=0;i<n;i++){
            a[k++]=getfact(i+1);
        }
        
        return a;
    }
    static int getfact(int i){
        if(i==0) return 0;
        if(i==1) return 1;
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%j==0){
                return j;
            }
        }
        return i;
    }
}