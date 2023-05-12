package adt;

public interface IDataStructures {
    void initialize();
    void insert(int element);
    void delete(int element);
    boolean contains(int element);
    int get(Object element);
    boolean isEmpty();
    int size();
    // void clear();
    // Iterator iterator();
}
