//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int thirdLargest(int a[], int n)
    {
        // Your code here
        int firstL=0, secondL=0, thirdL=0;
        
        for(int i=0; i<n; i++){
            if(a[i]>firstL){
                thirdL=secondL;
                secondL=firstL;
                firstL=a[i];
            }else if(a[i]>secondL){
                thirdL=secondL;
                secondL=a[i];
            } else if(a[i]>thirdL){
                thirdL=a[i];
            }
        }
        
        return thirdL;
    }
}
