class Solution {
    public boolean isPalindrome(String s) {
        char[] index = s.toLowerCase().toCharArray();

        int left = 0;  //Left Index
        int right = index.length - 1;  //Right Index

        while (left < right){
            while (left < right && !Character.isLetterOrDigit(index[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(index[right])) {
                right--;
            }
            if (index[left] != index[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
