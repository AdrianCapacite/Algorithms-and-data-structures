package adt;

public interface IGraphDataStructure {
    void initializeGraph(int numVertices);

    int getNumVertices();

    int getNumEdges();

    boolean hasEdge(int source, int destination);

    void addEdge(int source, int destination, int weight);

    void removeEdge(int source, int destination);

    int[] getAdjacentVertices(int source);

    char toLabel(int vertex);

    int toId(char label);
}
