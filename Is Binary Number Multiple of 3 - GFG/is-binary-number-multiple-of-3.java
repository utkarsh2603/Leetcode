//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


class Solution {
    int isDivisible(String s) {
        // code here
      java.math.BigInteger n= new java.math.BigInteger(s,2);  
      java.math.BigInteger d = new java.math.BigInteger("3");
      java.math.BigInteger a = n.mod(d);
      int i = a.intValue();
            if(i==0){
            return 1;
            }
            return 0;
    }
}  