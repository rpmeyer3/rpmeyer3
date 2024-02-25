// TODO: add the necessary imports
import java.util.*;
import java.util.Arrays;

/**
 * This class provides a method that does a heapsort.
 *
 * @author some one
 */

public class SortingAlgorithms {

    /**
     * A sort method that does heapsort
     * @param records the array of records to be sorted
     * @param c       the comparator to determine the order of the array.
     */
    public static <T> void heapsort(T[] records, Comparator<? super T> c) {
        // turn the input array of records into a heap in place
        // ... using siftUp
        for (int i = 1; i < records.length; i++) {
            siftUp(records, i, c);

        }
        printRecords("\nResulting heap:", records); // for Debugging


        //sort the array (heap) in place
        for (int k = records.length - 1; k >= 0; k--) {
            T t = records[0];
            records[0] = records[k];
            records[k] = t;
            siftDown(records, k, c);

        }
        printRecords("Sorted array: ", records); // for debugging

    }


    // You may add more sorting methods here. Try it!
    // For example:
    //              bubble sort
    //              selection sort
    //              insertion sort
    //              time sort

    // this method is used for debugging purpose.
    private static <T> void printRecords(String hdr, T[] records) {
        System.out.println(hdr);
        for (int i = 0; i<records.length; i++) {
            System.out.print("\t" + records[i]);
        }
        System.out.println();
    }

    /**
     * This method sifts a record up for the building of a heap in place.
     * @param records the array of records
     * @param i       indicates the i'th record is to be sifted up
     * @param c       the comparator to determine the order of the array.
     */
    public static <T> void siftUp(T[] records, int i, Comparator<? super T> c) {
        //TODO: add your code here
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (c.compare(records[i], records[parent]) <= 0) {
                break;
            }
            T temp = records[i];
            records[i] = records[parent];
            records[parent] = temp;
            i = parent;
        }
    }


    /**
     * This method sifts the root record down into a heap.
     * @param records the array of records
     * @param k       indicates the i'th record is to be shifted down
     * @param c       the comparator to determine the order of the array.
     */
    public static <T> void siftDown(T[] records, int k, Comparator<? super T> c ) {
        int parent = 0;

        while (parent < k - 1) {

            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;

            if (leftChild >= k) {
                break;
            }

            if (rightChild >= k) {
                if (c.compare(records[leftChild], records[parent]) > 0) {
                    T temp = records[leftChild];
                    records[leftChild] = records[parent];
                    records[parent] = temp;
                }
                break;

            }

            if (c.compare(records[parent], records[leftChild]) > 0 && c.compare(records[parent], records[rightChild]) > 0) {
                break;
            }
            int bc = (c.compare(records[leftChild], records[rightChild]) > 0) ? leftChild : rightChild;
            T t = records[bc];
            records[bc] = records[parent];
            records[parent] = t;
            parent = bc;
        }
    }





    public static <T> void bubbleSort(T[] records, Comparator<? super T> c) {
        int n = records.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (c.compare(records[i], records[j]) > 0) {
                    T temp = records[i];
                    records[i] = records[j];
                    records[j] = temp;
                }
            }
        }
    }

    public static <T> void selectionSort(T[] records, Comparator<? super T> c) {
        int n = records.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (c.compare(records[j], records[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = records[minIndex];
            records[minIndex] = records[i];
            records[i] = temp;
        }
    }

    public static <T> void insertionSort(T[] records, Comparator<? super T> c) {
        int n = records.length;
        for (int i = 1; i < n; ++i) {
            T key = records[i];
            int j = i - 1;
            while (j >= 0 && c.compare(records[j], key) > 0) {
                records[j + 1] = records[j];
                j = j - 1;
            }
            records[j + 1] = key;
        }
    }

    public static <T> void timSort(T[] records, Comparator<? super T> c) {
        int n = records.length;
        int minRun = 32;
        for (int i = 0; i < n; i += minRun) {
            insertionSort(records, i, Math.min(i + minRun - 1, n - 1), c);
        }
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(records, left, mid, right, c);
            }
        }
    }

    private static <T> void insertionSort(T[] records, int left, int right, Comparator<? super T> c) {
        for (int i = left + 1; i <= right; i++) {
            T temp = records[i];
            int j = i - 1;
            while (j >= left && c.compare(records[j], temp) > 0) {
                records[j + 1] = records[j];
                j--;
            }
            records[j + 1] = temp;
        }
    }

    private static <T> void merge(T[] records, int left, int mid, int right, Comparator<? super T> c) {
        int len1 = mid - left + 1, len2 = right - mid;
        T[] leftArr = Arrays.copyOfRange(records, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(records, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (c.compare(leftArr[i], rightArr[j]) <= 0) {
                records[k] = leftArr[i];
                i++;
            } else {
                records[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            records[k] = leftArr[i];
            k++;
            i++;
        }
        while (j < len2) {
            records[k] = rightArr[j];
            k++;
            j++;
        }
    }

}


