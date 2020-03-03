package online.test.shortpathtest;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPath {
	
	private Queue<GraphNode> queue;
	
	public ShortestPath() {
		this.queue = new LinkedList<>();
	}
	
	public int getShortestPathDistance(GraphNode startNode, GraphNode finishNode, Map<String, GraphNode> graph) {
		
		int shortestPath = -1;
		
		GraphNode current = graph.get(startNode.toString());
		current.setVisited(true);
		
		queue.add(current);
		
		while (!queue.isEmpty()) {
			current = queue.poll();
			if(current.equals(finishNode)) {
				break;
			}
			for (GraphNode node: current.getLinkedNodeList()) {
				if (!node.isVisited()) {
					node.setVisited(true);
					node.setPrev(current);
					queue.add(node);
					
				}
			}
		}
		
		if (!current.equals(finishNode)) {
			return shortestPath;
		}
		
		for (GraphNode node=graph.get(finishNode.toString());node != null; node = node.getPrev()) {
			shortestPath++;
		}
		
		return shortestPath;
	}
}
