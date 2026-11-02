class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {

            char c = abbr.charAt(j);

            // Letter
            if (c < '0' || c > '9') {
                if (word.charAt(i) != c) {
                    return false;
                }

                i++;
                j++;
            }

            // Number
            else {
                if (c == '0') {
                    return false;
                }

                int num = 0;

                while (j < abbr.length()) {
                    c = abbr.charAt(j);

                    if (c < '0' || c > '9') {
                        break;
                    }

                    num = num * 10 + (c - '0');
                    j++;
                }

                i += num;
            }
        }

        return i == word.length() && j == abbr.length();
    }
}