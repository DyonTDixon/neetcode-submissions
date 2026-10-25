public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a HashMap where Key = the number, Value = how many times it appears.
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            // If we've seen 'num' before, get its count. If not, default to 0. Then add 1.
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Maps cannot be sorted directly, so we create a List to hold tiny integer arrays.
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // Add a new 2-item array to our list: { frequency, original_number }
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        // Sort the list based on the frequency (which is sitting at index 0 of our tiny arrays).
        // Using b[0] - a[0] tells Java to sort them in DESCENDING order (highest frequency first).
        arr.sort((a, b) -> b[0] - a[0]);

        // Create our final result array of exactly size 'k'.
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            // Grab the top 'k' items from our sorted list.
            // index 1 of our tiny array holds the original_number we want to return.
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}