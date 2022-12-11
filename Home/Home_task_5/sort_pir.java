package Home.Home_task_5;

// Реализовать алгоритм пирамидальной сортировки HeapSort

import java.util.Arrays;
import java.util.Random;

public class sort_pir {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int length = 21;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("Рандом массив:\n" + Arrays.toString(arr));
        sort_pir ob = new sort_pir();
        ob.sort(arr);
        System.out.println("Сортировка: \n" + Arrays.toString(arr));
    }

}
