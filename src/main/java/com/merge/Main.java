package com.merge;

public class Main {
    public static void main(String[] args) {
        Integer[] array = { 38, 27, 43, 3, 9, 82, 10 };
        MergeSort<Integer> sorter = new MergeSort<>();
        sorter.sort(array);
        for (Integer num : array) {
            System.out.print(num + " ");
        }
    }
}