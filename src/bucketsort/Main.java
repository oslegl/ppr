package bucketsort;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Data.generateRandomFile("random.txt", -1000, 1000, 10000000);
        List<Integer> list = Data.loadDataFromFile("random.txt");
        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        BucketSort.sort(array, 5);
        
    }
    
}
