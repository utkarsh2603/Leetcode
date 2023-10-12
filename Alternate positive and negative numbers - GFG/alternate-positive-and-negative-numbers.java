//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        int j=0,k=n-1;
        int[]ar=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                ar[j++]=arr[i];
            }
            else{
                ar[k--]=arr[i];
            }
        }
        int p=j;
       // System.out.print(j);
        j=-1;
        k=n;
        for(int i=0;i<n;i++){
            if(k==p){
                j++;
                arr[i]=ar[j];
                continue;
                
            }
            if(j==p-1){
                k--;
                arr[i]=ar[k];
               // System.out.println(ar[k]);
               continue;
            }
            if(i%2==0){
                k--;
                arr[i]=ar[k];
            }
            else{
                j++;
                arr[i]=ar[j];
            }
        }
    }
}