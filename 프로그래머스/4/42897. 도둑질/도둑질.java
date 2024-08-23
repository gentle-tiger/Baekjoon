class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
                if (n == 1) return nums[0]; // 집이 하나일 때

        int[] dp = new int[n];
        
        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i < n-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = nums[1];
        
        for(int i=2; i<n; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }
        return Math.max(dp[n-2], dp2[n-1]);
    }
}