package com.merge;

import java.lang.reflect.Array;

public class MergeSort<T extends Comparable<T>> {

    /**
     * This method implements the recursive merge sort algorithm.
     * It divides the array into two halves and sorts each half recursively.
     * After sorting, it merges the two halves.
     *
     * @param a_array The array to be sorted.
     * @param ai_left  The starting index of the array/sub-array to sort.
     * @param ai_right The ending index of the array/sub-array to sort.
     */
    private void mergeSort(T[] a_array, int ai_left, int ai_right) {
        // Base case: if the sub-array has more than one element
        if (ai_right > ai_left) {
            // Find the middle point to divide the array into two halves
            int li_mid = ai_left + (ai_right - ai_left) / 2;

            // Recursively sort the left and right halves
            mergeSort(a_array, ai_left, li_mid);
            mergeSort(a_array, li_mid + 1, ai_right);

            // Merge the two halves after sorting
            merge(a_array, ai_left, li_mid, ai_right);
        }
    }

    /**
     * This method merges two sorted sub-arrays into one sorted array.
     * It compares the elements of the left and right sub-arrays and places
     * them in the correct order in the original array.
     *
     * @param a_array  The array containing the sub-arrays to merge.
     * @param ai_left  The starting index of the left sub-array.
     * @param ai_mid   The ending index of the left sub-array (middle point).
     * @param ai_right The ending index of the right sub-array.
     */
    private void merge(T[] a_array, int ai_left, int ai_mid, int ai_right) {
        // Find the lengths of the left and right sub-arrays
        int li_LeftLength = ai_mid - ai_left + 1;
        int li_RightLength = ai_right - ai_mid;

        // Create temporary arrays for the left and right sub-arrays
        T[] la_Left = (T[]) Array.newInstance(a_array.getClass().getComponentType(), li_LeftLength);
        T[] la_Right = (T[]) Array.newInstance(a_array.getClass().getComponentType(), li_RightLength);

        // Copy the data into the temporary arrays
        System.arraycopy(a_array, ai_left, la_Left, 0, li_LeftLength);
        System.arraycopy(a_array, ai_mid + 1, la_Right, 0, li_RightLength);

        // Indices to keep track of the current element in the left, right, and merged arrays
        int i = 0, j = 0, k = ai_left;

        // Merge the arrays while both sub-arrays have elements left
        while (i < li_LeftLength && j < li_RightLength) {
            if (la_Left[i].compareTo(la_Right[j]) < 0) {
                a_array[k++] = la_Left[i++];
            } else {
                a_array[k++] = la_Right[j++];
            }
        }

        // Copy any remaining elements from the left sub-array, if any
        while (i < li_LeftLength) {
            a_array[k++] = la_Left[i++];
        }

        // Copy any remaining elements from the right sub-array, if any
        while (j < li_RightLength) {
            a_array[k++] = la_Right[j++];
        }
    }

    /**
     * This method sorts the entire array using the merge sort algorithm.
     * It first checks if the array is null or has less than two elements.
     *
     * @param a_array The array to be sorted.
     */
    public void sort(T[] a_array) {
        if (a_array == null || a_array.length < 2) {
            return;  // No need to sort if the array is null or has less than 2 elements
        }
        mergeSort(a_array, 0, a_array.length - 1);
    }
}
