class Solution {
    public int maximumScore(int[] nums, int k) {
        int minimum = nums[k];
        int max_score = nums[k];
        int i = k;
        int j = k;
        int n = nums.length;

        while (i > 0 || j < n - 1) {
            // Check if we can expand the subarray
            if (i > 0 && j < n - 1) {
                // Expand the subarray towards the side with the larger neighbor
                if (nums[i - 1] >= nums[j + 1]) {
                    i--;
                } else {
                    j++;
                }
            } else if (i == 0 && j < n - 1) {
                j++;
            } else if (j == n - 1 && i > 0) {
                i--;
            }

            // Update the minimum and the maximum score
            minimum = Math.min(minimum, Math.min(nums[i], nums[j]));
            max_score = Math.max(max_score, minimum * (j - i + 1));
        }

        return max_score;        
    }
}