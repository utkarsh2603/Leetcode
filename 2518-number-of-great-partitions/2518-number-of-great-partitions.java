class Solution {
    int mod = 1000000007;
    
    public int countPartitions(int[] nums, int k) {     
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {                    
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - nums[i - 1]]) % mod;
                }
                
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= 2000) {
                break;
            }
        }
        long no = 0, total = 1, dupNo = 0;
        
        for (int j = 0; j < k; j++) {
            no = (no + dp[n][j]) % mod;
            if (sum - j < k) dupNo = (dupNo + dp[n][j]) % mod;
        }
        
        for (int i = 0; i < n; i++) {
            total = (total * 2) % mod;
        }        
        
        long res = ((total - 2 * no + dupNo) % mod + mod) % mod;
        return (int)res;
    }
}