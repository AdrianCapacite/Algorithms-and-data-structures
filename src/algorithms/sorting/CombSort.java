package algorithms.sorting;

public class CombSort implements ISortingAlgorithm {

    public static void main(String[] args) {
        System.out.println("==== CombSort demo ====");

        TestSorting testSorting = new TestSorting();

        testSorting.testSorting(new CombSort());

    }

    /**
     * Sorts an array using the comb sort algorithm.
     * Comb sort is an improvement over bubble sort.
     * It works by comparing elements that are far apart, and then slowly decreasing the gap between them.
     * Complexity: O(n^2)
     */
    @Override
    public void sort(int[] array) {
        int gap = array.length;
        double shrink = 1.3;
        boolean sorted = false;

        while (!sorted) {
            gap = (int) Math.floor(gap / shrink);

            // If the gap is 1, then the array is sorted
            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }

            // Compare elements that are gap apart
            for (int i = 0; i + gap < array.length; i++) {
                // Swap elements if they are in the wrong order
                if (array[i] > array[i + gap]) {
                    swap(array, i, i + gap);
                    sorted = false; // If gap is 1 and the array is not sorted, then the array is not sorted
                }
            }
        }
    }

    @Override
    public void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
