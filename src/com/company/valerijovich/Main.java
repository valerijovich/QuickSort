package com.company.valerijovich;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(999);
        }

        System.out.println("Initial array is: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array is: " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int from, int to) {

        if (from < to) {
            int divideIndex = partition(array, from, to);
            quickSort(array, from, divideIndex - 1);
            quickSort(array, divideIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to) {

        int leftIndex = from;
        int rightIndex = to;
        int pivot = array[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot)
                leftIndex++;

            while (array[rightIndex] > pivot)
                rightIndex--;

            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
