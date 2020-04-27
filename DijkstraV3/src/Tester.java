
/**
 * Write a description of class DijkstraRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String [] args) {
        
        
        // make the Nodes
        DijkstraNode nodeA = new DijkstraNode("A");
        DijkstraNode nodeB = new DijkstraNode("B");
        DijkstraNode nodeC = new DijkstraNode("C");
        DijkstraNode nodeD = new DijkstraNode("D");
        DijkstraNode nodeE = new DijkstraNode("E");
        DijkstraNode nodeF = new DijkstraNode("F");

        
        


        
        //add the edges
        nodeA.addEdge(nodeB, 10);    // destination node, distance
        nodeA.addEdge(nodeC, 15);

        nodeB.addEdge(nodeC, 8);
        nodeB.addEdge(nodeE, 20);
        nodeB.addEdge(nodeF, 15);
                        
        nodeC.addEdge(nodeE, 10);
                                
        nodeD.addEdge(nodeE, 2);       
        nodeD.addEdge(nodeF, 1);
                                                        
        nodeF.addEdge(nodeE, 5);
        
        // create the graph and add the nodes
        DijkstraGraph dGraph = new DijkstraGraph();
        dGraph.addNode(nodeA);
        dGraph.addNode(nodeB);
        dGraph.addNode(nodeC);        
        dGraph.addNode(nodeD);        
        dGraph.addNode(nodeE);        
        dGraph.addNode(nodeF);
        
        System.out.println( dGraph );    // before Dijkstra
        dGraph.calculateShortestPathFromSource(nodeA);   // calculate Dijkstra
        System.out.println ( dGraph );   // after
    }
}
/* Expected Output:
 * Before Dijkstra
 * 
Graph: [
Node Name: C Edges:  (E,10) Distance:  Shortest Path: []
Node Name: B Edges:  (F,15) (D,12) Distance:  Shortest Path: []
Node Name: F Edges:  (E,5) Distance:  Shortest Path: []
Node Name: D Edges:  (F,1) (E,2) Distance:  Shortest Path: []
Node Name: A Edges:  (C,15) (B,10) Distance:  Shortest Path: []
Node Name: E Edges:  Distance: Shortest Path: []
]
 * 
 * After Dijkstra
Graph: [
Node Name: C Edges:  (E,10) Distance: 15 Shortest Path: [A ]
Node Name: B Edges:  (F,15) (D,12) Distance: 10 Shortest Path: [A ]
Node Name: F Edges:  (E,5) Distance: 23 Shortest Path: [A B D ]
Node Name: D Edges:  (F,1) (E,2) Distance: 22 Shortest Path: [A B ]
Node Name: A Edges:  (C,15) (B,10) Distance: 0 Shortest Path: []
Node Name: E Edges:  Distance: 24 Shortest Path: [A B D ]
]
 */
