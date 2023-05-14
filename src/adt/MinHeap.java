package adt;

import java.util.Arrays;

import console.Colors;

public class MinHeap implements IDataStructures, Colors {

    public static void main(String[] args) {
        System.out.println(PURPLE + "==== Heap demo ====" + RESET);

        MinHeap heap = new MinHeap(10);
        for (int i = 0; i < 10; i++) {
            heap.insert((int) (Math.random() * 100));
        }

        System.out.println(heap);

        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }

        System.out.println(heap);
    }

    int size;
    int[] heap;

    public MinHeap(int heapSize) {
        heap = new int[heapSize + 1];
        size = 0;
    }

    @Override
    public void insert(int element) {
        if (size == heap.length) {
            System.out.println("Heap is full");
            return;
        }

        heap[++size] = element;
        siftUp(size);
    }

    public void siftUp(int index) {
        int value = heap[index];
        heap[0] = Integer.MIN_VALUE;

        // While the value is less than the parent
        while (value < heap[index / 2]) {
            heap[index] = heap[index / 2];
            index /= 2;
        }

        heap[index] = value;
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }

        heap[0] = heap[1];
        heap[1] = heap[size--];
        siftDown(1);
        return heap[0];
    }

    public void siftDown(int index) {
        int value = heap[index];
        int child = index * 2; // Left child

        // While loop is within the bounds of the heap
        for (; child <= size; child *= 2) {
            // If the right child is less than the left child
            if (child < size && heap[child] > heap[child + 1]) {
                child++;
            }

            // Stop if the value is less than the child
            if (value < heap[child]) break;

            // Move the child up
            heap[index] = heap[child];
            index = child;
        }

        // Place the value in the correct position
        heap[index] = value;
    }

    @Override
    public boolean contains(int element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public int get(Object element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "Heap [heapSize=" + size + ", heapArray=" + Arrays.toString(heap) + "]";
    }

}
