
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

    /*
    I think the time complexity of this is O(n) linear.
    It may look like O(n^2) because it has nested loops.
    The outer for loop is O(n), obviously. n = number of words in strs array
    The inner while loop is not O(n), but a constant. This is because the while loop is dependent on the length of firstWord, which is a constant
    Therefore the time complexity is O(c * n) = O(n)
    */
    public static String fasterLongestCommonPrefix(String[] strs) {
        String firstWord = strs[0];

        for (int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
            String wordLookingAt = strs[wordIndex];

            while(wordLookingAt.indexOf(firstWord) != 0) { // while firstWord is not in word
                firstWord = firstWord.substring(0, firstWord.length() - 1); // Keep removing the last letter of firstWord

                // Keep removing the last letters until there's nothing left or only common letters remain
                // Because you're removing the last letter every iteration, the only common letters remaining will be the prefix
            }
        }
        return firstWord;
    }


    public static void main(String[] args) {
        String[] words = {"flower" ,"flow", "flight"};

        System.out.println(fasterLongestCommonPrefix(words));
    }
}