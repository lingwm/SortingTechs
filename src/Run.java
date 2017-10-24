import java.io.File;

/**
 * Start
 * Created by Lingwei Meng on 2017/10/21.
 */
public class Run {
    public static void main(String[] args){
        LoadData l=new LoadData();
        File file=new File("datasets/RandomNumber4.txt");
        int[] array=l.readFile(file);
        Analyze a=new Analyze();

        a.outputTimeAnalyze(array);


    }
}
