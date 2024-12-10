# MergeSort Algorithm in Java

This is a Java implementation of the **Merge Sort** algorithm. Merge Sort is a **divide and conquer** sorting algorithm that divides the array into two halves, recursively sorts each half, and then merges them in a sorted manner.

## Features:
- **Generic Implementation**: This implementation works with any data type that implements the `Comparable` interface.
- **Efficient Sorting**: Merge Sort has an average and worst-case time complexity of **O(n log n)**, making it one of the most efficient sorting algorithms.
- **Stable Sort**: Merge Sort preserves the relative order of elements with equal values.

## How it works:
1. **Divide**: The array is recursively divided into two halves.
2. **Conquer**: The sub-arrays are sorted recursively.
3. **Combine**: The sorted halves are merged back together in a sorted order.

## Code Overview:

- **`mergeSort`**: This is the recursive function that divides the array into two halves.
- **`merge`**: This function merges two sorted sub-arrays into a single sorted array.
- **`sort`**: This is the public method used to start the merge sort process. It checks if the array is `null` or contains fewer than two elements.

## Example Usage:

Here is an example of how to use the `MergeSort` class to sort an array of integers:

```java
public static void main(String[] args) {
    Integer[] array = {38, 27, 43, 3, 9, 82, 10};
    MergeSort<Integer> sorter = new MergeSort<>();
    sorter.sort(array);

    // Print the sorted array
    for (Integer num : array) {
        System.out.print(num + " ");
    }
}
