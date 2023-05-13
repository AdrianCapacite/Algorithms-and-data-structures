package adt;

import console.Colors;

/**
 * GraphAdjList - Adjacency List implementation of a graph data structure.
 * Index 0 is not used.
 * Vertex 0 is not used.
 */
public class GraphAdjList implements IGraphDataStructure, Colors {

    /**
     * AdjEdge - Adjacency List implementation of an edge.
     */
    private class AdjEdge {
        int vertex;
        AdjEdge next;
        int weight;

        public AdjEdge(int vertex, AdjEdge next, int weight) {
            this.vertex = vertex;
            this.next = next;
            this.weight = weight;
        }

        // Sentinel constructor
        public AdjEdge() {
            this(0, null, 0);
            this.next = this;
        }

        @Override
        public String toString() {
            if (next == this) {
                return "Sentinel";
            }
            return "(" + toLabel(vertex) + "|" + weight + ")";
        }

    }

    public static void main(String[] args) {
        System.out.println(PURPLE + "==== GraphAdjList demo ====" + RESET);

        // Create a graph with 13 vertices and 22 edges
        GraphAdjList graph = new GraphAdjList(13);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 6, 2);
        graph.addEdge(1, 7, 6);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 4);
        graph.addEdge(4, 5, 2);
        graph.addEdge(4, 6, 1);
        graph.addEdge(5, 6, 2);
        graph.addEdge(5, 7, 1);
        graph.addEdge(5, 12, 4);
        graph.addEdge(6, 12, 2);
        graph.addEdge(7, 8, 3);
        graph.addEdge(7, 10, 1);
        graph.addEdge(7, 12, 5);
        graph.addEdge(8, 9, 2);
        graph.addEdge(9, 11, 1);
        graph.addEdge(10, 11, 1);
        graph.addEdge(10, 12, 3);
        graph.addEdge(10, 13, 2);
        graph.addEdge(12, 13, 1);

        System.out.println(graph);

    }

    // Graph variables
    private AdjEdge[] adjList;
    private AdjEdge sentinel;
    private int numVertices;
    private int numEdges;

    public GraphAdjList(int numVertices) {
        initializeGraph(numVertices);
    }

    @Override
    public void initializeGraph(int numVertices) {
        sentinel = new AdjEdge();
        this.numVertices = numVertices;
        adjList = new AdjEdge[numVertices + 1];
        for (int i = 1; i <= numVertices; i++) {
            adjList[i] = sentinel;
        }
        numEdges = 0;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    public AdjEdge[] getAdjList() {
        return adjList;
    }

    @Override
    public boolean hasEdge(int source, int destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasEdge'");
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        adjList[source] = new AdjEdge(destination, adjList[source], weight);
        adjList[destination] = new AdjEdge(source, adjList[destination], weight);
        numEdges++;
    }

    @Override
    public void removeEdge(int source, int destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeEdge'");
    }

    @Override
    public int[] getAdjacentVertices(int source) {
        int[] adjVertices = new int[numVertices];
        int i = 0;
        for (AdjEdge edge = adjList[source]; edge != sentinel; edge = edge.next) {
            adjVertices[i++] = edge.vertex;
        }

        return adjVertices;
    }

    @Override
    public char toLabel(int vertex) {
        return (char) (vertex + 64);
    }

    @Override
    public int toId(char label) {
        return (int) label - 64;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 1; i <= numVertices; i++) {
            str += toLabel(i) + ": ";
            for (AdjEdge edge = adjList[i]; edge != sentinel; edge = edge.next) {
                str += edge + " ";
            }
            str += "\n";
        }
        return str;
    }

}
