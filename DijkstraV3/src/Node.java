import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;


public class Node
{
    private String name;     
    private Map<Node, Integer> edges;
 
    public void addEdge(Node destination, int distance) {
        edges.put(destination, distance);
    }
  
    public Node(String name) {
        this.name = name;
        edges = new HashMap<Node, Integer>();
    }
    
    @Override public String toString() {
        String answer = "\nNode Name: " + this.name + " Edges: ";
        Set<Map.Entry<Node,Integer>> edgeSet = edges.entrySet();
        Iterator it = edgeSet.iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            answer += " (" + ((Node)pair.getKey()).getName()  
                + "," + pair.getValue() + ")";
        }
        return answer;
    }
     
    // getters and setters 
    public String getName() { return this.name; }
    public Map<Node, Integer> getEdges() { return edges; }

	public void addEdgeFromOther(Node d, int dist) {
		edges.put(d,dist);
	}

}
