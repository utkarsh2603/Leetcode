//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum occurring character in a string.
    static final int CHAR=256;
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        
        int[] count = new int[CHAR];
        int n=line.length();
        
        for(int i=0; i<n; i++){
                count[line.charAt(i)]++;
        }
        
        int max=0; char ans=0;
        for(int i=0; i<CHAR; i++){
                
                if(count[i] > max){
                    max=count[i];
                    ans=(char)i;
                }
        }
        
        return ans;
    }
    
}