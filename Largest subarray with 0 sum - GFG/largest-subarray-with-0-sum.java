//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int A[], int n)
    {
        HashMap <Integer,Integer> mp = new HashMap<>(); 
        int prefixSum = 0;
        int maxLength = 0;
        mp.put(0,-1);
        for(int i = 0 ; i < A.length ; i++) {
            prefixSum += A[i];
            
            //check if prefix sum exists already in map
            if(mp.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength ,(i-mp.get(prefixSum)));
            }
            else { // if the prefix sum is not contained in the map simply put it
                mp.put(prefixSum, i);
            }
            
        }
        return maxLength; 
    }
}