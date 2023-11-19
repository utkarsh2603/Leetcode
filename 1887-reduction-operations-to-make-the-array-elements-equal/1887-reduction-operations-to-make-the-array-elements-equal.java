class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        // finding pos of first non-equal element 
        int i=1;
        while(i<nums.length && nums[i]==nums[0]){
            i++;
        }
        int steps=0;
        int pos=0;
        for(;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                pos++;
            }
            steps+=pos;
        }
        return steps;
    }
}