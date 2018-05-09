package bucketsort;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Data {

    private final static Logger LOGGER = Logger.getLogger(Data.class.getName());
    
    
    public static void generateRandomFile(String fileName, int min, int max, int count){
        Path path = Paths.get("data/"+fileName).toAbsolutePath();
                
        try(FileChannel rwChannel = new RandomAccessFile(path.toString(), "rw").getChannel()){
            
            ByteBuffer wrBuf = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4*count);
            
            for(int i=0; i<count; i++){
                int rand = ThreadLocalRandom.current().nextInt(min, max + 1);
                wrBuf.putInt(rand);
            }
            rwChannel.close();
            
        }catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static List<Integer> loadDataFromFile(String fileName){
        List<Integer> result;
        Path path = Paths.get("data/"+fileName).toAbsolutePath();
        
        try (FileChannel fc = FileChannel.open(path)) {
            result = new ArrayList<>();
            long size = fc.size() / 4;
            MappedByteBuffer mbb = fc.map(MapMode.READ_ONLY, 0, size * 4l);
            for (int i = 0; i < size; i++) {
                result.add(mbb.getInt());
            }
            fc.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
