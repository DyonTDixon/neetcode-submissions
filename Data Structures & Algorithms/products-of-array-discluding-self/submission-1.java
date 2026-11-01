class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 1. Compute prefix products:
        // result[i] will contain the product of all elements to the left of index i
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 2. Compute suffix products on the fly and combine:
        // runningSuffix tracks the product of all elements to the right of index i
        int runningSuffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= runningSuffix;
            runningSuffix *= nums[i];
        }

        return result;
    }
}

