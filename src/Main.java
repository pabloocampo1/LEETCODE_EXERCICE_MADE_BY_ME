import Exercice.ContainsDuplicate;
import Exercice.ContainsNearbyDuplicate;
import Exercice.IsAnagram;
import Exercice.LongestCommonPrefix;

public class Main {
    public static void main(String[] args) {

        IsAnagram isAnagram = new IsAnagram();
        int[] list = {1,2,3,1,2,3};
        System.out.print(isAnagram.isAnagram("rat", "car"));
    }
}