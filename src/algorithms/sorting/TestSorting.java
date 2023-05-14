package algorithms.sorting;

import console.Colors;

public class TestSorting implements SampleArrays, Colors {

    public void testSorting(ISortingAlgorithm sortingAlgorithm) {
        System.out.println(PURPLE + "Testing " + sortingAlgorithm.getClass().getSimpleName() + RESET);

        // Print arrays
        printArrays();

        // Sort arrays
        System.out.println("\nSorting...\n");
        sortingAlgorithm.sort(ordered);
        sortingAlgorithm.sort(almostSorted);
        sortingAlgorithm.sort(random);
        sortingAlgorithm.sort(reverseOrdered);
        System.out.println("Done!\n");

        checkArrays();
        printArrays();
    }

    public void checkArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) throw new RuntimeException("Array not sorted!");
        }
    }

    public void checkArrays() {
        checkArray(ordered);
        checkArray(almostSorted);
        checkArray(random);
        checkArray(reverseOrdered);
        System.out.println(GREEN + "Arrays are sorted!" + RESET);
    }

    public void printArrays() {
        System.out.println("Ordered: " + java.util.Arrays.toString(ordered));
        System.out.println("Almost sorted: " + java.util.Arrays.toString(almostSorted));
        System.out.println("Random: " + java.util.Arrays.toString(random));
        System.out.println("Reverse ordered: " + java.util.Arrays.toString(reverseOrdered));
    }

}
