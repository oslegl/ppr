package bucketsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Data {

    private final static Logger LOGGER = Logger.getLogger(Data.class.getName());
    
    public static List<Integer> loadDataFromFile(String fileName){
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\data\\"+fileName);

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
    
    public static List<Integer> loadData(String fileName){
        List<Integer> result = new ArrayList<>();
        
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\data\\"+fileName);
        
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath), 10000);
            String[] line = br.readLine().split(" ");
            for(int i = 0; i < line.length; i++){
                int value = Integer.parseInt(line[i]);
                result.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    
    public static void generateRangeFile(String fileName, int from, int to){
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\data\\"+fileName);        
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));){
            for(int i = from; i <= to; i++){
                writer.write(i + " ");
            }
            writer.close();
        }catch(IOException e){}
    }
    
    public static void generateRangeWithOffsetFile(String fileName, int from, int offset, int count){
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\data\\"+fileName);        
        
        int value = from;
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));){
            for(int i = 0; i < count; i++){
                writer.write(value + " ");
                value += offset;
            }
            writer.close();
        }catch(IOException e){}
    }
}
