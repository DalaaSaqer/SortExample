    import java.util.*;

    public class SortExample {
        public static void main(String[] args) {
            // Define unsorted arrays
            Integer[] array1 = { 12, 13, 24, 10, 3, 6, 90, 70 };
            int[] array2 = { 2, 6, 3, 5, 1 };

            // Sort array1 using QuickSort and output it
            quickSort(array1, 0, array1.length - 1);
            System.out.println(Arrays.toString(array1));

            // Sort array2 using MergeSort and output it
            mergeSort(array2, array2.length);
            System.out.println(Arrays.toString(array2));
        }

        // Quick sort method: Sorts the array between low and high indices
        public static void quickSort(Integer[] arr, int low, int high) {
            if (arr == null || arr.length == 0) {
                return;
            }

            if (low >= high) {
                return;
            }

            // Choose pivot element
            int middle = low + (high - low) / 2;
            int pivot = arr[middle];

            // Partition the array around the pivot
            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(arr, i, j);  // Swap elements
                    i++;
                    j--;
                }
            }

            // Recursively apply QuickSort on the left and right partitions
            if (low < j) {
                quickSort(arr, low, j);
            }
            if (high > i) {
                quickSort(arr, i, high);
            }
        }

        // Swap method
        public static void swap(Integer[] array, int x, int y) {
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }

        // Merge sort method: Recursively divides and merges the array
        public static void mergeSort(int[] a, int n) {
            // Base condition for recursion
            if (n < 2) {
                return;
            }

            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            // Copy elements into left and right subarrays
            System.arraycopy(a, 0, left, 0, mid);
            System.arraycopy(a, mid, right, 0, n - mid);

            mergeSort(left, mid);
            mergeSort(right, n - mid);

            // Merge sorted subarrays
            merge(a, left, right, mid, n - mid);
        }

        // Merge method: Merge two sorted subarrays (left and right) into the original array
        public static void merge(int[] a, int[] left, int[] right, int leftSize, int rightSize) {
            int i = 0, j = 0, k = 0;

            // Merge left and right arrays into a
            while (i < leftSize && j < rightSize) {
                if (left[i] <= right[j]) {
                    a[k++] = left[i++];
                } else {
                    a[k++] = right[j++];
                }
            }

            while (i < leftSize) {
                a[k++] = left[i++];
            }

            while (j < rightSize) {
                a[k++] = right[j++];
            }
        }

        // Check if an array is sorted
        private static boolean isSorted(int[] x) {
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i] > x[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
