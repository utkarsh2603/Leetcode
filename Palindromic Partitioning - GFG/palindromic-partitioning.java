//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [][]dp = new int[500+1][500+1];
    static int palindromicPartition(String str)
    {
        // code here
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        int n = str.length();
        int i = 0;
        int j = (n-1);
        
        int res = solve(str,i,j);
        return res;
    }
    public static int solve(String s, int i , int j){
        
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(ispalindrome(s,i,j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int left,right;
            if(dp[i][k]!=-1){
                left = dp[i][k];
            }else{
                dp[i][k] = left = solve(s,i,k);
            }
            if(dp[k+1][j]!=-1){
                right = dp[k+1][j];
            }else{
                dp[k+1][j] = right = solve(s,k+1,j);
            }
            int temp_ans = 1+left+right;
            min = Math.min(min,temp_ans);
        }
        return dp[i][j]=min;
    }
    public static boolean ispalindrome(String s, int i, int j){
        boolean bool = true;
        int n = s.length();
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                bool = false;
                break;
            }
            i++;
            j--;
        }
        return bool;
    }
}