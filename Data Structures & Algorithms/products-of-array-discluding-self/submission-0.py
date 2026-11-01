class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n

        # 1. Compute prefix products:
        # result[i] will contain the product of all elements to the left of index i
        result[0] = 1
        for i in range(1, n):
            result[i] = result[i - 1] * nums[i - 1]

        # 2. Compute suffix products on the fly and combine:
        # runningSuffix tracks the product of all elements to the right of index i
        runningSuffix = 1
        for i in range(n - 1, -1, -1):
            result[i] *= runningSuffix
            runningSuffix *= nums[i]

        return result