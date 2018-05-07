import java.util.Random;

public class MergeSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = new Random().nextInt(100);
        }
        long t1 = System.currentTimeMillis();
//        megerSort(arr,0, arr.length - 1);
        insertionSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t2 - t1);
    }

    //插入排序
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
    
    public static void megerSort(int[] arr, int p, int r) {
        //长度大于1时继续分治
        if (p < r) {
            int q = 0;
            q = (p + r) /2;
            //分治
            megerSort(arr, p, q);
            megerSort(arr, q + 1, r);
            //归并
            meger(arr, p, q, r);
        }
    }
    
    //归并
    public static void meger(int[] arr, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        int i;
        int j;
        for (i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }
        left[n1] = Integer.MAX_VALUE;
        for (j = 0; j < n2; j++) {
            right[j] = arr[q + j + 1];
        }
        right[n2] = Integer.MAX_VALUE;
        
        i = 0; 
        j = 0;
        
        for (int k = p; k <=r; k++) {
            if (left[i] <= right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
        }
    }
    
}
