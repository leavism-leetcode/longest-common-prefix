
public class Solution {
    // O(n^2) time complexity
    // Super slow :(
    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        String result = "";

        // Edge case when it's just one word
        if(strs.length == 1) { return strs[0]; }

        for(int letterIndex = 0; letterIndex < first.length(); letterIndex++) {
            boolean matches = false;
            for(int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
                // Catches when the word we're looking at is shorter than the first word
                if(strs[wordIndex].length() == letterIndex) { return result; }

                Character goal = first.charAt(letterIndex);
                Character lookingAt = strs[wordIndex].charAt(letterIndex);

                if(lookingAt.equals(goal)) {
                    matches = true;
                } else {
                    return result;
                }
            }
            if(matches) { result += first.charAt(letterIndex); }
        }
        return result;
    }

    public static String fasterLongestCommonPrefix(String[] strs) {
        String firstWord = strs[0];

        // I think this is still O(n^2) time complexity
        for (int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
            String word = strs[wordIndex];

            while(word.indexOf(firstWord) != 0) { // while firstWord is not in word
                firstWord = firstWord.substring(0, firstWord.length() - 1); // Keep removing the last letter of firstWord

                // Keep removing letters until there's nothing left or only common letters remain
                // Because you're removing the last letter every iteration, the only common letters remaining will be the prefix
            }
        }
        return firstWord;
    }


    public static void main(String[] args) {
        String[] words = {"abab", "ab", ""};

        System.out.println(fasterLongestCommonPrefix(words));
    }
}