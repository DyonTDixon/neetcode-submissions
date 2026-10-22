class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            /* Takes the current word (like "tea") and 
            shatters it into a raw array of characters (['t', 'e', 'a']) 
            so the letters can be manipulated.*/
            char[] chars = strs[i].toCharArray();

            /* Stitches the sorted characters back together into a 
            standard string ("aet"). This becomes the universal signature 
            used to group matching anagrams.*/
            java.util.Arrays.sort(chars);

            String sortedKey = new String(chars);

            if  (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList <>());
            }

            map.get(sortedKey).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
