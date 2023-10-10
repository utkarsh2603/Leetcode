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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int N){
        // code here
        String s=" ";
        int length=Integer. MAX_VALUE ;
        for(int i=0;i<N;i++){
             if(arr[i].length()<length){
                 length=arr[i].length();
                 s=arr[i];
             }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<s.length();j++){
                if(arr[i].charAt(j)!=s.charAt(j)){
                    s=s.substring(0,j);
                }
            }
        }
        if(s.length()>0)
         return s;
         return "-1";
    }
}