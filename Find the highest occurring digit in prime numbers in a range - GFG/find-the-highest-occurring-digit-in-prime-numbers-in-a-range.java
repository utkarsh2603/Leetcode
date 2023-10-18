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
            System.out.println(ob.maxDigit(L,R));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    //Function for checking number is prime or not
    public static boolean isPrime(int n)
    {
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0)
                return false;
        }
        
        return true;
    }
    
    public int maxDigit(int L, int R)
    {
        // code here
        //Storing the prime number int the list between L to R 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = L; i <= R; i++)
        {
            boolean status = isPrime(i);
            if(status)
                list.add(i);
        }
        
        //store the frequency into map of each digit of the prime number 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++)
        {
            int num = list.get(i);
            
            while(num > 0)
            {
                int rem = num % 10;
                map.put(rem, map.getOrDefault(rem, 0)+1);
                num /= 10;
            }
        }
      //  System.out.println(map);
        //find the max frequent Of digit
        int maxFreq = 0;
        for(int key : map.keySet())
        {
            maxFreq = Math.max(maxFreq, map.get(key));
        }
      //  System.out.println("max fre = "+ maxFreq);
        // Loop for find max number with max frquency
        int max = Integer.MIN_VALUE;
        for(int key : map.keySet())
        {
            if(map.get(key) == maxFreq)
            {
                max = Math.max(max, key);
            }
        }
    //    System.out.println(list);
    
        if(max < 0)
            return -1;
        return max;
    }
}