class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int st=0;
        int end=nums.length-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(nums[mid]==target)
            return true;
            else if(target<nums[mid])
            end=mid-1;
            else
            st=mid+1;
        }
        return false;
    }
}