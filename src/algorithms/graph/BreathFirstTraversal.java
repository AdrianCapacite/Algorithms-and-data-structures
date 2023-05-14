package algorithms.graph;

import adt.GraphAdjList;
import adt.IGraphDataStructure;

public class BreathFirstTraversal implements IGraphTraversal {

    public static void main(String[] args) {
        System.out.println("==== BreathFirstTraversal demo ====");

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

        BreathFirstTraversal bfs = new BreathFirstTraversal(graph);

    }

    public BreathFirstTraversal(IGraphDataStructure graph) {
        initialize(graph);
    }

    @Override
    public void traverse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'traverse'");
    }

    @Override
    public void visit(int node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void markVisited(int node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'markVisited'");
    }

    @Override
    public boolean isVisited(int node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isVisited'");
    }

    @Override
    public boolean isTraversalComplete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isTraversalComplete'");
    }

    @Override
    public String toString() {
        return "BreathFirstTraversal []";
    }

    @Override
    public void initialize(IGraphDataStructure graph) {
        
    }

}
