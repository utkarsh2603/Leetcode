//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    static int[] dp;
    public int solve(int n)
    {
        if(n==0){
            return 1;
        }
        else if(n<0){
            return 0;
        }
        else if(dp[n]!=-1){
            return dp[n];
        }
        else{
            dp[n]=(solve(n-1)+solve(n-2))%1000000007;
            return dp[n];
        }
    }
    int countWays(int n)
    {
        dp=new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }
        return solve(n);
    }
}