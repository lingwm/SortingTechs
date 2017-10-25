/**
 * Measure degree of sortedness of the input array
 * @param array
 * compare every adjacent pair of number.  if left <= right --> add 1 to sortedNumber
 * degree of sortedness = (sortedNumber / totalNumber) * 100%
 * Created by Yuxiao Guo
 */

import java.io.File;

public class DegreeOfSorted {
    public void dos(String fileName){
    //read data array
        LoadData l = new LoadData();
        File file = new File(fileName);
        int[] init_array = l.readFile(file);

        int sortedNumber = 0, i;
        for(i = 0; i < init_array.length - 1; i++){
            if(init_array[i] <= init_array[i + 1]){
                sortedNumber++;
            }
        }
        double res = (double)sortedNumber * 100 / init_array.length;
        System.out.println(res);



    }
}
