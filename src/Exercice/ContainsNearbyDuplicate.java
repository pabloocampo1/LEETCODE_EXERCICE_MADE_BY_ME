package Exercice;

import java.util.*;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {


        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++ ){

            // si existe entonces compramos
            if(numbers.containsKey(nums[i])){

                Integer posicionDelElemento = numbers.get(nums[i]);
                if((posicionDelElemento - i) <= k){
                    return true;
                }

            }

            // guardamos el numero como key y el indice como valor
            numbers.put(nums[i], i);
        }
        return false;
    }
}
