import java.util.Random;

/**
 * 
 * @author honglei
 *
 */
public class FindMaximunSubArray {
    
    public static void main(String[] args) {
        int length = 100;
        int[] array = new int[length];
        FindMaximunSubArray subArray = new FindMaximunSubArray();
        for (int i = 0; i < length; i++) {
            array[i] = (new Random().nextInt(20)) - 10;
            System.out.print(array[i] + ", ");
        }

//        long t1 = System.currentTimeMillis();
        
//        subArray.findMaxSubarray(array);
        MaxSumArray maxSumArray = subArray.findMaxSubarray(array, 0, length - 1);
        System.out.println(maxSumArray.getStart() + ", " + maxSumArray.getEnd() + ", " + maxSumArray.getSum());
//        long t2 = System.currentTimeMillis();
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(t2 - t1);
    }

    public MaxSumArray findMaxCrossingSubarray(int array[], int low, int mid, int high) {
        MaxSumArray maxSumArray = new MaxSumArray();
        int leftSum = Integer.MIN_VALUE;
        int sum = 0; 
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft= i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0; 
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight= i;
            }
        }
        maxSumArray.setStart(maxLeft);
        maxSumArray.setEnd(maxRight);
        maxSumArray.setSum(leftSum + rightSum);
        return maxSumArray;
    }
    
    public MaxSumArray findMaxSubarray(int array[], int low, int high) {
        MaxSumArray maxSumArray = new MaxSumArray();
        
        if (high == low) {
            maxSumArray.setStart(low);
            maxSumArray.setEnd(high);
            maxSumArray.setSum(array[low]);
        } else {
            int mid = (low + high) / 2;
            MaxSumArray maxSumLeft = findMaxSubarray(array, low, mid);
            MaxSumArray maxSumRight = findMaxSubarray(array, mid + 1, high);
            MaxSumArray maxSumCross = findMaxCrossingSubarray(array, low, mid, high);
            if (maxSumLeft.getSum() >= maxSumRight.getSum() && maxSumLeft.getSum() >= maxSumCross.getSum()) {
                maxSumArray.setStart(maxSumLeft.getStart());
                maxSumArray.setEnd(maxSumLeft.getEnd());
                maxSumArray.setSum(maxSumLeft.getSum());
            } else if (maxSumRight.getSum() >= maxSumLeft.getSum() && maxSumRight.getSum() >= maxSumCross.getSum()) {
                maxSumArray.setStart(maxSumRight.getStart());
                maxSumArray.setEnd(maxSumRight.getEnd());
                maxSumArray.setSum(maxSumRight.getSum());
            } else {
                maxSumArray.setStart(maxSumCross.getStart());
                maxSumArray.setEnd(maxSumCross.getEnd());
                maxSumArray.setSum(maxSumCross.getSum());
            }
        }
        return maxSumArray;
    }
    
    public void findMaxSubarray(int[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++ ) {
            int temp = 0;
            for (int j = i; j < array.length; j++){
                temp += array[j];
                if (temp > sum) {
                    sum = temp;
                }
            }
        }
        System.out.println(sum);
    }
    
    public class MaxSumArray {
        private int start;
        private int end;
        private int sum;
        public void setStart(int start) {
            this.start = start;
        }
        public int getStart() {
            return this.start;
        }
        public void setEnd(int end) {
            this.end = end;
        }
        public int getEnd() {
            return this.end;
        }
        public void setSum(int sum) {
            this.sum = sum;
        }
        public int getSum() {
            return this.sum;
        }
    }
}
