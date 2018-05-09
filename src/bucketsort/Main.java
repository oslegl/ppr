package bucketsort;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Data.generateRandomFile("data.bin", -200, 200, 1000000);
        List<Integer> list = Data.loadDataFromFile("data.bin");
        Integer[] data = new Integer[list.size()];
        data = list.toArray(data);
        System.out.println("data size: " + data.length);       
        BucketSort.sort(data, 5);
    }
    
}
