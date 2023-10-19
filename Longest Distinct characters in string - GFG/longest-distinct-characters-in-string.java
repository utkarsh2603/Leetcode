//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        int n = S.length();
        int res = 0;
        
         for(int i = 0; i < n; i++){
             boolean[] visited = new boolean[256];
             
             for(int j = i;j < n; j++){
                 //if current char is visited then exit from the fo loop
                 if(visited[S.charAt(j)] == true)
                 break;
                 // if its not visited then find max among res and right - left + 1, then set visited as true
                 else{
                     res = Math.max(res, j - i + 1);
                     visited[S.charAt(j)] = true;
                 }
             }
             //removing first char of previous window
             visited[S.charAt(i)] = false;
         }
         
         return res;
        
    }
}