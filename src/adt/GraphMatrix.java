package adt;

import console.Colors;

public class GraphMatrix implements IGraphDataStructure, Colors {

    public static void main(String[] args) {
        System.out.println(PURPLE + "==== GraphMatrix demo ====" + RESET);
    }

    public GraphMatrix() {
        // TODO Auto-generated constructor stub
        throw new UnsupportedOperationException("Unimplemented constructor");
    }

    @Override
    public int getNumVertices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumVertices'");
    }

    @Override
    public int getNumEdges() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumEdges'");
    }

    @Override
    public boolean hasEdge(int source, int destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasEdge'");
    }

    @Override
    public void addEdge(int source, int destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
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
    public String toString() {
        return "GraphMatrix []";
    }

    @Override
    public int initializeGraph(int numVertices) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initializeGraph'");
    }



}
