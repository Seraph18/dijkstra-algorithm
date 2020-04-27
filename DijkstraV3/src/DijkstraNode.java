import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DijkstraNode extends Node
{
    private Integer distance; 
    private List<DijkstraNode> shortestPath;  
    private HashMap<DijkstraNode, Integer> edges;
    
    public DijkstraNode(String name) {
        super(name);
        distance = Integer.MAX_VALUE;   // represents infinity
        shortestPath = new LinkedList<DijkstraNode>();
        edges = new HashMap<DijkstraNode, Integer>();
    }
    @Override public void addEdge(Node d, int dist) {
    	d = (DijkstraNode)d;
    	d.addEdgeFromOther(this, dist);
    	edges.put((DijkstraNode) d,dist );
    }
    @Override public void addEdgeFromOther(Node d, int dist) {
    	edges.put((DijkstraNode) d,dist);
    }
    public HashMap<DijkstraNode, Integer> getAllEdges(){
    	return this.edges;
    }
    @Override public String toString() {
        String answer = "\nNode Name: " + this.getName() + " Edges: ";
        Set<Entry<DijkstraNode, Integer>> edgeSet = edges.entrySet();
        Iterator it = edgeSet.iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            answer += " (" + ((Node)pair.getKey()).getName()  
                + "," + pair.getValue() + ")";
        }
        
        String stringDistance = "";
        if (this.distance == Integer.MAX_VALUE)
             stringDistance = "(OO)";  // infinity symbol
        else
             stringDistance = this.distance + "";
        
        answer += " Distance: " + stringDistance + " Shortest Path: [";
        for (int i=0; i<shortestPath.size(); ++i)
            answer += this.shortestPath.get(i).getName() + " ";
        return answer + "]";
    }
    

    // getters and setters
    public int getDistance() { return this.distance; }
    public List<DijkstraNode> getShortestPath() { return this.shortestPath; }
    
    public void setDistance(int distance) { this.distance = distance; }
    public void setShortestPath(List<DijkstraNode> startPath) {
        this.shortestPath = startPath;
    }
}
