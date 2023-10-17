//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr,0,(int)N-1);
    }
    
    private static long mergeSort(long[] arr, int l, int h)
    {
        if(l<h)
        {
            int mid=l+(h-l)/2;
            long l1=mergeSort(arr,l,mid);
            long l2=mergeSort(arr,mid+1,h);
            long l3=merge(arr,l,mid,h);
            //System.out.println("l1: "+l1+", l2: "+l2+", l3: "+l3);
            return (l1+l2+l3);
        }
        else return 0;
    }
    
    private static long merge(long[] arr, int l, int mid, int h)
    {
        long[] b=new long[h-l+1];
        int i=l, j=mid+1, k=0;
        long count=0;
        
        while(i<=mid && j<=h)
        {
            if(arr[i]>arr[j])
            {
                b[k++]=arr[j++];
                count+=(mid-i+1);
            }
            else
            {
                b[k++]=arr[i++];
            }
        }
        
        while(i<=mid)
        {
            b[k++]=arr[i++];
        }
        
        while(j<=h)
        {
            b[k++]=arr[j++];
        }
        
        int t=l;
        for(k=0;k<b.length;k++)
        {
            arr[t++]=b[k];
        }
        
        return count;
    }
}