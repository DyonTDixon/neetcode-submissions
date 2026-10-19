class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create the empty Hash
        HashSet<Integer> seenNumb = new HashSet<>();
        
        // Loop through each Numbers
        for (int n : nums){
            if (seenNumb.contains(n)){
                return true;
            } else {
                seenNumb.add(n);
            }
        }
        return false;
    }
}