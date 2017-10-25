import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read data from files to sort
 * Created by Lingwei Meng on 2017/10/21.
 */
public class LoadData {

    /**
     * read data from a file
     * transform to int array and return
     * @param file
     * @return
     */
    public int[] readFile(File file){
        BufferedReader reader=null;
        String tempstr;
        ArrayList<String> readlist=new ArrayList<>();
        int lines=0;
        try{
            reader=new BufferedReader(new FileReader(file));
            while ((tempstr=reader.readLine())!=null){
                readlist.add(tempstr);
                lines++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        int[] array=new int[lines];
        for (int i=0;i<lines;i++){
            array[i]=Integer.parseInt(readlist.get(i));
        }
        return array;
    }
}
