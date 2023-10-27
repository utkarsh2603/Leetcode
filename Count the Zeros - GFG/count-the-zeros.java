//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().countZeroes(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
     int countZeroes(int[] arr, int n) {
        
        int s = 0;
        int e = n-1;
        int mid  = s + (e-s)/2;
        
        while(s <= e) {
            if(arr[mid] == 0)  e = mid-1;
            if(arr[mid] == 1)  s = mid+1;
            mid = s + (e-s)/2;
        }
        return n-e-1;
    }


}
