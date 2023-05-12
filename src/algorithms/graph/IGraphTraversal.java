package algorithms.graph;

import adt.IGraphDataStructure;

public interface IGraphTraversal {
    void initialize(IGraphDataStructure graph);
    void traverse();
    void visit(int node);
    void markVisited(int node);
    boolean isVisited(int node);
    boolean isTraversalComplete();
}
