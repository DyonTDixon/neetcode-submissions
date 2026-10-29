public class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String word : strs) {
            // Append length, then the delimiter, then the word itself
            res.append(word.length()).append("#").append(word);
        }
        return res.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0; // Our main pointer starting at the beginning of the string
        
        // Keep reading until the pointer reaches the end of the encoded string
        while (i < s.length()) {
            // Find the very next '#' starting from our current position 'i'
            int hashIndex = s.indexOf("#", i);
            
            // Extract the number part and convert it to an integer
            int length = Integer.parseInt(s.substring(i, hashIndex));
            
            // Calculate where the word starts and ends
            int wordStart = hashIndex + 1;
            int wordEnd = wordStart + length;
            
            // Extract the actual word and add it to our result list
            String word = s.substring(wordStart, wordEnd);
            res.add(word);
            
            // Move our main pointer to the start of the next encoded chunk
            i = wordEnd; 
        }
        
        return res;
    }
}