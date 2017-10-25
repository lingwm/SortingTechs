import java.io.*;
import java.util.ArrayList;


/**
 * process the Geolife data
 * Created by Lingwei Meng on 2017/10/24.
 */
public class RowData {

    public void rowDataProcess(){
        BufferedReader reader=null;
        String tempstr;
        ArrayList<String> readlist=new ArrayList<>();
        File root=new File("geolife");
        File[] files=root.listFiles();
        for(File file:files){
            try{
                reader=new BufferedReader(new FileReader(file));
                while ((tempstr=reader.readLine())!=null){
                    String[] a=tempstr.split(",");
                    String[] b=a[1].split("\\.");
                    readlist.add(b[0]+b[1]);
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
        }



        final String NEW_LINE = "\r\n";
        StringBuilder csvStr = new StringBuilder();
        try{
            File fileout=new File("geolife1.txt");
            if (fileout.createNewFile()){

                for(int i=0;i<5000;i++){
                    csvStr.append(readlist.get(i)).append(NEW_LINE);
                }

                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileout)));
                writer.write(csvStr.toString());
                writer.flush();
                writer.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
