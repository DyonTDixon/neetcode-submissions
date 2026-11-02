class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        int i = 0; // pointer for word
        int j = 0; // pointer for abbr

        while (j < abbr.length()) {

            // Current abbreviation character is a digit
            if (Character.isDigit(abbr.charAt(j))) {

                // Leading zero is not allowed
                if (abbr.charAt(j) == '0') {
                    return false;
                }

                int num = 0;

                // Build the complete number
                while (j < abbr.length() &&
                       Character.isDigit(abbr.charAt(j))) {

                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }

                // Skip characters in word
                i += num;

                // Make sure we didn't skip past word
                if (i > word.length()) {
                    return false;
                }

            } else {

                // No character exists to compare
                if (i >= word.length()) {
                    return false;
                }

                // Letters don't match
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }

                i++;
                j++;
            }
        }

        return i == word.length();

    }
}