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



    /**
     * created by Yuxiao Guo
     * @param array
     */
    public void merge(int[] array){
        // use res array to temperately store the result.
        int[] res = new int[array.length];
        mergeSort(array, 0, array.length - 1, res);
    }

    private void mergeSort(int[] array, int start, int end, int[] res) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(array, start, mid, res);
        mergeSort(array, mid+1, end, res);
        merge(array, start, mid, end, res);
    }

    private void merge(int[] array, int start, int mid, int end, int[] res) {
        int left = start;
        int right = mid+1;
        int index = start;

        // merge two sorted subarrays to result array
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                res[index++] = array[left++];
            } else {
                res[index++] = array[right++];
            }
        }
        while (left <= mid) {
            res[index++] = array[left++];
        }
        while (right <= end) {
            res[index++] = array[right++];
        }

        // copy result back to original array
        for (index = start; index <= end; index++) {
            array[index] = res[index];
        }
    }

    /**
     * created by Yuxiao Guo
     * @param array
     */
    public void quick(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        // choose middle point as pivot
        int pivot = array[(start + end) / 2];

        //put all element that <= pivot to the pivot's left side
        //put all element that > pivot to the pivot's right side
        while (left <= right) {
            // key point 3: array[left] < pivot not array[left] <= pivot
            while (left <= right && array[left] < pivot) {
                left++;
            }
            // key point 3: array[right] > pivot not array[right] >= pivot
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left++;
                right--;
            }
        }
        //recursively sort left and right subarray.
        quickSort(array, start, right);
        quickSort(array, left, end);
    }
}
