package bucketsort;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<Integer> data = Data.getDataFromFile("pattern.txt");
        
        Data.generatePatternFile("pattern.txt", "10 0", 10000);
        
    }
    
}
