class Solution {
    public int singleNumber(int[] nums) {
          int[]a = new int[1000000];
        int[]k = new int[1000000];
        int c=0;
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            if(b<0){
                b=-1*b;
                k[b]++;
            }
            else {
                a[b]++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i]==1){
                c=i;
            }
            if (k[i]==1){
                c=-1*i;
            }
        }
        return c;
    }
}