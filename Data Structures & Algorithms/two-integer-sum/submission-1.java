class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seenNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seenNumbers.containsKey(complement)) {
                return new int[]{seenNumbers.get(complement), i};
            } else {
                seenNumbers.put(nums[i], i);
            }
        }
        return null;
    }
}
