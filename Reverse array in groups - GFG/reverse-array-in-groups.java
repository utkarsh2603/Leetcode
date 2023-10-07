//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        
        //while testcases exist
        while(t-->0){
            
            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);
            
            ArrayList<Integer> arr = new ArrayList<>();            
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }
            
            Solution obj = new Solution();
            obj.reverseInGroups(arr, n, k);
            
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        ArrayList<Integer> rev = new ArrayList<Integer>();
        int h = 1;
        while((h*k)<=n)
        {
            for(int i=(h*k)-1; i>=(h-1)*k; i--)
            {
                rev.add(arr.get(i));
            }
            h += 1;
        }
        h -= 1;
        if((h*k) != n)
        {
            for(int i=n-1; i>=(h*k); i--)
            {
                rev.add(arr.get(i));
            }
        }
        for(int i=0; i<n; i++)
        {
            arr.set(i, rev.get(i));
        }
        
    }
}
