package Exercice;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer number : nums){
                map.computeIfAbsent(number, key -> 0);
                map.compute(number, (key, v) -> key == null ? 0 :  v + 1);
        }

        List<Integer> keys =
                map.entrySet()
                        .stream()
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .limit(k)
                        .map(Map.Entry::getKey)
                        .toList();


        int[] array = keys.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return array;
    }
}
