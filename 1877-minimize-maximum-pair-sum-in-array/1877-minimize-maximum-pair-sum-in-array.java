class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1, pairSum = 0, maxPairSum = 0;
        while(left < right){
           pairSum = nums[left++] + nums[right--];
           maxPairSum = Math.max(maxPairSum, pairSum);
        }
        return maxPairSum;
    }
}