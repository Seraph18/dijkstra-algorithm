
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstraGraph {
	private Set<DijkstraNode> nodes;

	Set<DijkstraNode> visitedNodes;
	Set<DijkstraNode> unvisitedNodes;
	public DijkstraGraph() {
		nodes = new HashSet<DijkstraNode>();
		visitedNodes = new HashSet<DijkstraNode>();
		unvisitedNodes = new HashSet<DijkstraNode>();
	}

	public void addNode(DijkstraNode ds) {
		nodes.add(ds);
	}

	public void calculateShortestPathFromSource(DijkstraNode focusNode) {
		focusNode.setDistance(0);

		

			unvisitedNodes.add(focusNode);
			
			while (unvisitedNodes.size() != 0) {
					DijkstraNode focus = getLowestDistance(unvisitedNodes); 
					unvisitedNodes.remove(focus); 
					for(Map.Entry<DijkstraNode, Integer> pair : focus.getAllEdges().entrySet()) {
						DijkstraNode currNode = pair.getKey();
						Integer currVal = pair.getValue();
						if (!visitedNodes.contains(currNode)) {
							calculateMinimumDistance(currNode, currVal, focus);
							unvisitedNodes.add(currNode);
						}
					}
					visitedNodes.add(focus);
				}
	}

	private void calculateMinimumDistance(DijkstraNode evaluationNode, Integer edgeWeight, DijkstraNode focusNode) {
		Integer sourceDist = focusNode.getDistance();
		if(sourceDist + edgeWeight < evaluationNode.getDistance()) {
			if(evaluationNode.getDistance() == Integer.MAX_VALUE) {
			}else {
			}
			evaluationNode.setDistance(sourceDist + edgeWeight);
			LinkedList<DijkstraNode> shortPath = new LinkedList<DijkstraNode>(focusNode.getShortestPath());
			shortPath.add(focusNode);
			evaluationNode.setShortestPath(shortPath);
		}
	}

	private DijkstraNode getLowestDistance(Set<DijkstraNode> unvisitedNodes) {
		DijkstraNode lowestNodeConn = new DijkstraNode("-1");
		int lowestEdge = Integer.MAX_VALUE;
		for(DijkstraNode dn : unvisitedNodes) {
			int nodeDist = dn.getDistance();
			if(nodeDist<lowestEdge) {
				lowestEdge = nodeDist;
				lowestNodeConn = dn;
			}
		}
		return lowestNodeConn;
	}

	public String toString() {
		String ret = "";
		ret+= ("Printing DGraph \n");
		 ret += "Graph: [\n";
		Iterator it = nodes.iterator();
		while (it.hasNext()) {
			ret += it.next().toString() + "\n ";
		}
		return ret;
	}
}