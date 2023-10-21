//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends

class Solution {
    static Long[] lcmAndGcd(Long A, Long B) {
        Long[] result = new Long[2];

        // Calculate GCD using Euclidean Algorithm
        result[1] = gcd(A, B);

        // Calculate LCM using the formula LCM(A, B) = (A * B) / GCD(A, B)
        result[0] = (A * B) / result[1];

        return result;
    }

    static Long gcd(Long a, Long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

 