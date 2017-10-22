/**
 * Sorting functions
 * Created by Lingwei Meng on 2017/10/21.
 */
public class Sorter {

    /**
     * insertion sort
     * @param array to be sorted
     */
    public void insertion(int[] array){
        int current;
        for (int i=1;i<array.length;i++){
            current=array[i];     //take out current element
            int j=i;              //set current position
            while (j>0&&array[j-1]>current){      //compare current element with left elements until find a correct position
                array[j]=array[j-1];           //shift
                j--;
            }
            array[j]=current;       //insert current element to the correct position
        }
    }


    public void selection(int[] array){}

    public void bubble(int[] array){}

    public void merge(int[] array){}

    public void quike(int[] array){}
}
