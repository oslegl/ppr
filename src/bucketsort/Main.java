package bucketsort;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
//        Data.generateRandomFile("random.txt", -1000, 1000, 10000000);
//        List<Integer> list = Data.loadDataFromFile("random.txt");

        List<Integer> bufferedLoad = Data.loadData("random.txt");
        
        List<Integer> scannerLoad = Data.loadDataFromFile("random.txt");
        
//        Integer[] array = new Integer[list.size()];
//        array = list.toArray(array);
//        BucketSort.sort(array, 5);
//        System.out.println("data: " + Arrays.toString(array));

        
    }
    
}
