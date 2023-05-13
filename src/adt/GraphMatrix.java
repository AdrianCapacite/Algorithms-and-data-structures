package adt;

import console.Colors;

public class GraphMatrix implements IGraphDataStructure, Colors {

    public static void main(String[] args) {
        System.out.println(PURPLE + "==== GraphMatrix demo ====" + RESET);

        // Create a graph with 13 vertices and 22 edges
        GraphMatrix graph = new GraphMatrix(13);
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

    private int[][] adjMatrix;
    private int numVertices;
    private int numEdges;

    public GraphMatrix(int numVertices) {
        initializeGraph(numVertices);
    }

    @Override
    public void initializeGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices + 1][numVertices + 1];
        for (int i = 1; i < numVertices; i++) {
            for (int j = 1; j < numVertices; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        numEdges = 0;
    }

    @Override
    public int getNumVertices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumVertices'");
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public boolean hasEdge(int source, int destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasEdge'");
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        adjMatrix[source][destination] = weight;
        adjMatrix[destination][source] = weight;
        numEdges++;
    }

    @Override
    public void removeEdge(int source, int destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeEdge'");
    }

    @Override
    public int[] getAdjacentVertices(int source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdjacentVertices'");
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
        StringBuilder sb = new StringBuilder();

        // Print the column labels
        sb.append("   ");
        for (int i = 1; i <= numVertices; i++) {
            sb.append(toLabel(i)).append("  ");
        }

        // Print the row labels and the adjacency matrix
        sb.append("\n");
        for (int i = 1; i <= numVertices; i++) {
            sb.append(toLabel(i)).append(" ");
            for (int j = 1; j <= numVertices; j++) {
                if (adjMatrix[i][j] == 0) {
                    sb.append("   ");
                    continue;
                }
                sb.append(String.format("%2d", adjMatrix[i][j])).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
