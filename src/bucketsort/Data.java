package bucketsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static java.lang.Integer.max;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Data {

    private final static Logger LOGGER = Logger.getLogger(Data.class.getName());
    
    public static List<Integer> getDataFromFile(String fileName){
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\data\\"+fileName);
        System.out.println("filepath long: " + filePath);

        List<Integer> result = new ArrayList<>();
        
        try{
            Scanner scanner = new Scanner(new File(filePath)).useDelimiter(" ");
            while(scanner.hasNextInt()){
                result.add(scanner.nextInt());
            }

            
        }catch(FileNotFoundException e){
            LOGGER.info("file was not found");
            return null;
        }
        
        LOGGER.info("file successfully read, integer counts: " + result.size());
        return result;
    }
    
    public static void generateRandomFile(String fileName, int from, int to, int count){
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\data\\"+fileName);        
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));){
            for(int i = 0; i < count; i++){
                int randomNum = ThreadLocalRandom.current().nextInt(from, to + 1);
                writer.write(randomNum + " ");
            }
            writer.close();
        }catch(IOException e){}
    } 
    
    public static void generatePatternFile(String fileName, String pattern, int count){
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\data\\"+fileName);        
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));){
            for(int i = 0; i < count; i++){
                writer.write(pattern + " ");
            }
            writer.close();
        }catch(IOException e){}
    }
}
