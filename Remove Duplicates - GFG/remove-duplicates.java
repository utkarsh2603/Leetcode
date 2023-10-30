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
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    String removeDups(String S) {
        // code here
        
        //We are using a set because set can`t contian duplicates and we can leverage its working. 
       Set<Character> set = new HashSet();
       
       String ans = "";
       
       for(int i=0;i<S.length();i++){
            
            //if there is going to be a duplicate the if statement will be false and won`t work.
            if(set.add(S.charAt(i)))
            {
                ans+=S.charAt(i);
            }
       }
       return ans;    
    }
}