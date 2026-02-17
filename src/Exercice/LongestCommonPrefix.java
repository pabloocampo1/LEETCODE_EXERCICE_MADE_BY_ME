package Exercice;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String wordBase = strs[0];
        String result = "";

        if(strs.length == 1){
            return strs[0];
        }

        for (int i = 0; i < wordBase.length() ; i++) {
            char letter = wordBase.charAt(i);

            for (int j = 1; j < strs.length ; j++) {

                if(i == strs[j].length() || strs[j].charAt(i) != letter){
                    result = wordBase.substring(0, i);
                    return wordBase.substring(0, i);
                }

            }


        }

        return result;



    }
}
