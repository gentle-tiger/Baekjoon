class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }
}