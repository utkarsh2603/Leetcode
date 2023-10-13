public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<Integer.SIZE;i++) {
            //check whether last bit is set or not
            int k = (int)(n & 1);//without type casting ,it is of boolean type

            //if ith bit is set then add it to the ans
            if(k > 0) {
                ans += (int)(1L << (31-i));
            }
            //move it to right one time to check the last bit again in the next iteration
            n = n >> 1;
        }
        return ans;
    }
}