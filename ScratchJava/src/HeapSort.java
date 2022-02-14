import java.util.ArrayList;
import java.util.Arrays;
public class HeapSort {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 1, 3, 4, 2, 6};
        int[] arr2 = {99, 23, 412, 56, 23, 49, 523};
        System.out.println(Arrays.toString(heapSort(arr1)));
        System.out.println(Arrays.toString(heapSort(arr2)));
    }
    public static int [] heapSort(int[] lst) {
        int N = lst.length;
        int count=0;
        ArrayList<Integer> heap = new ArrayList<>();
        int[] result = new int [N];

        for(int i = 0; i < N; i++) {
            heapAdd(heap, lst[i]);
        }
        for(int i = (N-1)/2; i >= 0; --i) {
            maxHeapify(heap, i , N);
        }
        for (int i = N - 1; i >= 0; --i) {
            int temp = heap.get(0);
            heap.set(0,heap.get(i));
            heap.set(i,temp);
            maxHeapify(heap, 0, i);
        }

        while (heap.size()>0) {
            result[(N-1)-count]=heapExtractMax(heap);
            count++;
        }
        return result;
    }
    public static void heapAdd(ArrayList<Integer> heap, int num) {
        heap.add(num);
    }
    public static void maxHeapify(ArrayList<Integer> heap, int index, int N) {
        int max = index;
        int leftSubtree = 2 * index + 1;
        int rightSubtree = 2 * index + 2;

        if (leftSubtree < N && heap.get(leftSubtree) > heap.get(max)) {
            max = leftSubtree;
        }
        if (rightSubtree < N && heap.get(rightSubtree) > heap.get(max)) {
            max = rightSubtree;
        }
        if (index != max) {
            int temp1 = heap.get(index);
            int temp2 = heap.get(max);
            heap.set(index, temp2);
            heap.set(max, temp1);
            maxHeapify(heap,max, N);
        }
    }
    public static int heapExtractMax(ArrayList<Integer> heap) {
        int max=heap.get((heap.size()-1));
        heap.remove(heap.size()-1);
        return max;
    }
}