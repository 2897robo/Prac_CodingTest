import java.util.Scanner;

public class Main {
    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        long inv_count = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i] > arr[j] implies all the remaining elements in left subarray (arr[i...mid])
                // are greater than arr[j]
                temp[k++] = arr[j++];
                inv_count += (mid - i + 1);  // Count inversions
            }
        }
        
        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Copy the sorted subarray into Original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        
        return inv_count;
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long inv_count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            
            inv_count += mergeSortAndCount(arr, temp, left, mid);
            inv_count += mergeSortAndCount(arr, temp, mid + 1, right);
            inv_count += mergeAndCount(arr, temp, left, mid, right);
        }
        return inv_count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        
        int[] temp = new int[n];
        long swapCount = mergeSortAndCount(a, temp, 0, n - 1);
        
        System.out.println(swapCount);
    }
}
