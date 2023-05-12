package adt;

public interface IGraphDataStructure {
    int initializeGraph(int numVertices);
    int getNumVertices();
    int getNumEdges();
    boolean hasEdge(int source, int destination);
    void addEdge(int source, int destination);
    void removeEdge(int source, int destination);
    int[] getAdjacentVertices(int source);
}
