package algorithms.sorting;

import javax.xml.transform.SourceLocator;

import console.Colors;

public class BubbleSort implements ISortingAlgorithm, SampleArrays, Colors {

    public static void main(String[] args) {
        System.out.println(PURPLE + "==== BubbleSort demo ====" + RESET);

        TestSorting testSorting = new TestSorting();

        testSorting.testSorting(new BubbleSort());
    }

    /**
     * Sorts an array using the bubble sort algorithm.
     * Complexity: O(n^2)
     `
     * @param array The array to sort
     * @return The sorted array
     */
    @Override
    public void sort(int[] array) {
        // For each element in the array
        for (int i = 0; i < array.length; i++) {
            // Move the largest element to the end
            boolean swapped = false;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    @Override
    public void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
