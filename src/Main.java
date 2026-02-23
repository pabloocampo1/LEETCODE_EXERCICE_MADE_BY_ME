import Exercice.*;

import javax.lang.model.element.Name;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        TopKFrequent topKFrequent = new TopKFrequent();
        int[] list  = {1,2,1,2,1,2,3,1,3,2};


        System.out.print(Arrays.toString(topKFrequent.topKFrequent(list, 2)));



    }
}


