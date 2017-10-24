import java.io.File;

/**
 * Analyze performance of sorting techniques and output results
 * Created by Lingwei Meng on 2017/10/21.
 */
public class Analyze {
    public void outputTimeAnalyze(){
        //read data array
        LoadData l=new LoadData();
        File file=new File("datasets/RandomNumber5.txt");
        int[] init_array=l.readFile(file);

        //sort
        long[] average=new long[5];
        for(int j=0;j<6;j++){            //run 6 times and get average of last 5 times
            long[] single=new long[5];
            for (int i=1;i<=5;i++){      //run 5 types of sorting tech
                //replicate a new array for sorting
                int[] array=new int[init_array.length];
                for (int k=0;k<init_array.length;k++){
                    array[k]=init_array[k];
                }
                //sort
                long temp=timeAnalyze(array,i);
                if (j!=0){               //remove runtime of first run
                    average[i-1]+=temp;  //accumulate runtime of 5 runs
                }
                //record runtime of single run
                single[i-1]=temp;
            }
            System.out.println(single[0]+","+single[1]+","+single[2]+","+single[3]+","+single[4]);
        }
        for(int i=0;i<5;i++){       //calculate average
            average[i]=average[i]/5;
        }

        System.out.println("Average:");
        System.out.println(average[0]+","+average[1]+","+average[2]+","+average[3]+","+average[4]);
    }

    public long timeAnalyze(int[] array,int type){
        long startTime=System.nanoTime();
        sort(array,type);
        long endTime=System.nanoTime();
        long runtime=(endTime-startTime)/1000;
        return runtime;
    }








    private void sort(int[] array,int type){
        Sorter s=new Sorter();
        switch (type){
            case 1:
                s.insertion(array);
                break;
            case 2:
                s.selection(array);
                break;
            case 3:
                s.bubble(array);
                break;
            case 4:
                s.merge(array);
                break;
            case 5:
                s.quick(array);
                break;
            default:
                System.out.println("incorrect sorting type input");
        }
    }
}
