//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        int ans = 0;
        int end = -1;
        int max = 0;
        
        for(int i=0;i<arr.length-1;i+=1){
            if(i>end){
                ans+=1;
                end = max;
            }
            max = Math.max(max,arr[i]+i);
            if(max>=arr.length-1){
                return ans;
            }
            if(max<=i)
                return -1;
        }
        return ans;
    }
}