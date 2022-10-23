public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        String result = "";

        for(int letterIndex = 0; letterIndex < first.length(); letterIndex++) {
            Boolean matches = false;
            for(int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
                Character goal = first.charAt(letterIndex);
                Character lookingAt = strs[wordIndex].charAt(letterIndex);

                if(lookingAt.equals(goal)) {
                    matches = true;
                } else {
                    matches = false;
                    return result;
                }
            }

            if(matches) { result += first.charAt((letterIndex)); }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix(words));
    }
}