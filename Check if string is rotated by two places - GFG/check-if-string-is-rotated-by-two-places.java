//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
    if(str1.equals(str2)) return true;
     
     if(str1.length()<2 || str2.length()<2) {
        str1+="xx"; //Since, below I've taken s1 and s2 from str1 and str2 in such a way that a 
        str2+="xx"; //substring would be possible only when the length of string is 3 or more.
     }
     String s1 = str1.substring(0, str1.length()-2);
     String s2 = str2.substring(2, str2.length());
     
     if(s1.equals(s2)) return true;
     s1 = str1.substring(2, str1.length());
     s2 = str2.substring(0, str2.length()-2);
     
     if(s1.equals(s2)) return true;
     return false;
    }

}