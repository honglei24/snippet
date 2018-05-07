import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        //初始化数组
        int N = 1000000;
        int[] arr = new int[N];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = new Random().nextInt(100);
        }
        try {
            //堆排序
            HeapSort heapSort = new HeapSort();
            heapSort.heapSort(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (int k = 0; k < arr.length; k++) {
//            System.out.print(arr[k] + ", ");
//        }
    }
    
    /**
     * 堆排序
     * @param A
     */
    public void heapSort(int[] A) {
        buildMaxHeap(A); //构建最大堆，
        int heapSize = A.length;
        int temp;
        for (int i = A.length - 1; i >= 1; i--){
            //将根元素与堆得最好一个元素互换
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapSize--;
            //减少堆的大小，对剩余元素维持最大堆性质
            maxHeapify(A, 0, heapSize);
        }
    }
    
    /**
     * 构建最大堆，父节点大于等于子节点
     * @param A 对象数组
     */
    private void buildMaxHeap(int[] A) {
        int heapSize = A.length;
        //堆非叶节点调整
        for (int i = A.length / 2 - 1; i >= 0; i-- ) {
            maxHeapify(A, i, heapSize);
        }
    }
    
    /**
     * 维持堆性质
     * @param A 数组
     * @param i 元素index
     * @param heapSize 堆大小
     */
    private void maxHeapify(int[] A, int i, int heapSize) {
        int left = 2 * i + 1; //左值
        int right = 2 * i + 2; //右值
        int largest = i; //三者中最大的
        if (left < heapSize && A[left] > A[i]) {
            largest = left;            
        }
        if (right < heapSize && A[right] > A[largest]) {
            largest = right;            
        }
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest, heapSize);
        }
    }
}
