//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int L = Integer.parseInt(input[0]); 
            int R = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.primeSetBits(L,R));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int primeSetBits(int L, int R)
   {
       int ans = 0;
       for(int i=L;i<=R;i++){
           String binary = Integer.toBinaryString(i);
           int setBits = 0;
           for(char c : binary.toCharArray()){
               if(c == '1'){
                   setBits++;
               }
           }
           if(isPrime(setBits)){
               ans++;
           }
       }
       return ans;
   }
   
   public static boolean isPrime(int num){
       if(num == 0 || num == 1){
           return false;
       }
       
       for(int i=2;i<=Math.sqrt(num);i++){
           if(num%i == 0){
               return false;
           }
       }
       return true;
   }
}