package algorithms.sorting;

import adt.MaxHeap;

public class HeapSort implements ISortingAlgorithm {

    public static void main(String[] args) {
        System.out.println("==== HeapSort demo ====");

        TestSorting testSorting = new TestSorting();
        testSorting.testSorting(new HeapSort());

    }

    @Override
    public void sort(int[] array) {
        MaxHeap heap = new MaxHeap(array);

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = heap.remove();
        }

    }

    @Override
    public void swap(int[] array, int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }

}
