public class Solution {
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

    public static void main(String[] args) {
        String[] words = {"ab","a"};

        System.out.println(longestCommonPrefix(words));
    }
}