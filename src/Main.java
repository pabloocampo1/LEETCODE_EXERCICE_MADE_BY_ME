import Exercice.*;

import javax.lang.model.element.Name;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] list  = {"eat","tea","tan","ate","nat","bat"};

        System.out.print(groupAnagrams.groupAnagrams(list));



    }
}


