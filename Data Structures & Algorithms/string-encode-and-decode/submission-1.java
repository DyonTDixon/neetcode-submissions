class Solution {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String word : strs) {
            // 1. Double up any existing backslashes
            // 2. Put a backslash in front of any commas
            String escapedWord = word.replace("\\", "\\\\").replace(",", "\\,");
            
            // Append the safely escaped word, followed by our actual comma delimiter
            res.append(escapedWord).append(",");
        }
        return res.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i);
            
            if (c == '\\') {
                // We found an escape character! 
                // Blindly add the VERY NEXT character to our word, whatever it is.
                currentWord.append(s.charAt(i + 1));
                i += 2; // Jump past both the backslash and the escaped character
            } else if (c == ',') {
                // We found a pure, unescaped comma! 
                // This means our word is finished.
                res.add(currentWord.toString());
                currentWord.setLength(0); // Reset the builder for the next word
                i += 1;
            } else {
                // It is just a normal letter
                currentWord.append(c);
                i += 1;
            }
        }
        return res;
    }
}