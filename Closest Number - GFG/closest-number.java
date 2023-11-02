//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.closestNumber(N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int closestNumber(int N , int M) {
        // code here
        int  rem = N % M;
            if(rem==0)//here if N<M then return N;
        {
            return N;
        }
        int i=N,j=N;//this two values is used to check forward and backword values
        while(true)
        {
            if(i%M==0)
            {
                return i;
            }else{
                i--;//here we come backword
            }
            
            if(j%M==0)
            {
                return j;
            }else{
                j++;//then we move forward
            }
        }
    }
};