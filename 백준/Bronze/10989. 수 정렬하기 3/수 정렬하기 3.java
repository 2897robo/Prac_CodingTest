import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Read the number of elements in the input array
        int n = Integer.parseInt(br.readLine());

        // Initialize the input array and find the maximum value in it
        int[] a = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (a[i] > max) max = a[i];
        }

        // Initialize the counting array B with the size of max+1
        int[] b = new int[max + 1];  // B's size should be max+1 to cover all values from 0 to max
        int[] c = new int[n];  // This array will store the sorted result

        // Call the countingSort function
        countingSort(a, b, c, n, max);

        // Write the sorted output to the console
        for (int i : c) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // k == max number
    // n == number of data in A
    public static void countingSort(int[] A, int[] B, int[] C, int n, int k) {
        // Initialize the counting array B with 0
        for (int i = 0; i <= k; i++) {  // B array size is k+1
            B[i] = 0;
        }

        // Update the counting values (how many times each value appears in A)
        for (int i = 0; i < n; i++) {
            B[A[i]]++;
        }

        // Calculate the cumulative sum in B
        for (int i = 1; i <= k; i++) {
            B[i] += B[i - 1];
        }

        // Place values into the result array C using the cumulative sum
        for (int i = n - 1; i >= 0; i--) {
            C[B[A[i]] - 1] = A[i];
            B[A[i]]--;  // Decrease the count of the current value in B
        }
    }
}
