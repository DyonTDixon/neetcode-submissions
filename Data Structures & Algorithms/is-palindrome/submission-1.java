class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase()
        .replaceAll("[^a-zA-Z0-9]", "");

        char[] index = s.toCharArray();

        int left = 0;  //Left Index
        int right = index.length - 1;  //Right Index

        while (left < right){
            if (index[left] != index[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
