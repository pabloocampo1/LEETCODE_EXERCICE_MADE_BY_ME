package Exercice;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mapAnagrams = new HashMap<>();

        for (String word : strs){
            char[] wordList = word.toCharArray();
            Arrays.sort(wordList);

            String wordSorted = new String(wordList);

             mapAnagrams.computeIfAbsent(wordSorted, k -> new ArrayList<>()).add(word);
        }

        
        return new ArrayList<>(mapAnagrams.values());
    };

    


}
