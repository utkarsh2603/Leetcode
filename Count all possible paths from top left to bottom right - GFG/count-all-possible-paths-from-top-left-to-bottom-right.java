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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
        // code here
        long arr[][]=new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=-1;
            }
        }
        
        return count(arr,0,0,m,n);
    }
    
    
    public long count(long arr[][],int r,int c,int m,int n){
        if(r+1==m&&c+1==n){
            return 1;
        }
        
        if(arr[r][c]!=-1){
            return arr[r][c];
        }
        
        long sum=0;
        if(r+1!=m){
            sum=(sum+count(arr,r+1,c,m,n))%(1000000000+7);
        }
        if(c+1!=n){
            sum=(sum+count(arr,r,c+1,m,n))%(1000000000+7);
        }
        
        return arr[r][c]=sum;
    }
}