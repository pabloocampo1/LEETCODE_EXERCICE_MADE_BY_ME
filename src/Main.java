import Exercice.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] list = {2,5,5,11};
        

        System.out.print(Arrays.toString(twoSum.twoSum(list, 10)));
    }
}