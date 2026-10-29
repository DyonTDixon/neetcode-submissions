class Solution {
    public boolean isPalindrome(int x) {
        // Edge Case 1: Negative numbers are never palindromes (e.g., -121 reversed is 121-)
        if (x < 0) {
            return false;
        }

        // We need to keep a copy of the original number to compare at the very end
        int original = x; 
        int reversedNum = 0;

        // Keep peeling digits until x is reduced to 0
        while (x != 0) {
            int digit = x % 10;                        // 1. Peel off the last digit
            reversedNum = (reversedNum * 10) + digit;  // 2. Shift existing digits left and add the new one
            x = x / 10;                                // 3. Chop the last digit off the end of x
        }

        // If our mathematically reversed number perfectly matches the original, we have a palindrome
        return original == reversedNum;
    }
}