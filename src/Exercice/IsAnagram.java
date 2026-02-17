package Exercice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        if(s.equals(t)){
            return true;
        }

        char[] w1 = s.toCharArray();
        char[] w2 = t.toCharArray();

        Arrays.sort(w1);
        Arrays.sort(w2);




        for (int i = 0; i < w1.length ; i++) {

                if(w1[i] != w2[i]){
                    return false;
                }

        }

        return true;
    }
}
