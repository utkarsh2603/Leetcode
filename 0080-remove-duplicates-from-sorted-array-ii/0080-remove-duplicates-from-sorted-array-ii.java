class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j= 0 , n = nums.length, state = 0 ;

        while(j<n) {
            if(state==0) {
                if(j<n-1 && nums[j]==nums[j+1]) {
                    state = 1;
                    nums[i] = nums[j];
                    nums[i+1] = nums[j] ;
                    i += 2;
                    j += 2;
                }
                else {
                    nums[i] = nums[j];
                    i++;
                    j++;
                }
            }
            else {
                if(nums[j]==nums[j-1]) {
                    j++;
                }
                else {
                    if(j<n-1 && nums[j]==nums[j+1]) {
                        nums[i] = nums[j] ;
                        nums[i+1] = nums[j] ;
                        i += 2;
                        j += 2;
                        state = 1;
                    }
                    else {
                        nums[i] = nums[j] ;
                        i++;
                        j++;
                    }
                }
            }
        }

        return i;
    }
}