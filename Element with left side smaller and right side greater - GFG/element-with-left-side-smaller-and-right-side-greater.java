//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java
class Compute {
    public int findElement(int arr[], int n){
        
        int ans=-1;
        if(n==1 || n==2)
        return -1;
        
     
        int mx[]=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            mx[i]=max;//storing in max array
        }
        
        int mi[]=new int[n];
        int min=Integer.MAX_VALUE;
     
          //for the minimum array start the loop from back 
          for(int i=n-1;i>=0;i--){
              min=Math.min(min,arr[i]);
              mi[i]=min;
          }
          
          
        
          //i started the loop from i equal to 1 to n-1 beacuse beacuse extreme
          //elements cannot be the answer so no need to check fo that 
            for(int i=1;i<n-1;i++)
          {
              
              //now simpley check wheter any point where min and max array have equal element 
              //and that will be our require answer
              if(mi[i]==mx[i])
              {
                  ans=mx[i];
                  break;
              }
              
          }
     
        
       
        return ans;
    }

}