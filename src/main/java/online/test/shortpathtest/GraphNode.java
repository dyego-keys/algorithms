package online.test.shortpathtest;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
	/**
	 * Returns all the GraphNodes directly linked to this GraphNode. These are
	 * considered to be distance 1 from this node.
	 */
	private Set<GraphNode> directlyLinkedNodes;
	private boolean visited = false;
	private GraphNode prev = null;
	private String name;
	
	public GraphNode(String name) {
		this.name = name;
		directlyLinkedNodes = new HashSet<>();
	}
	
	void addLinkedNode(GraphNode graphNode) {
		this.directlyLinkedNodes.add(graphNode);
	}
	
	public Set<GraphNode> getLinkedNodeList() {
		return this.directlyLinkedNodes;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public GraphNode getPrev() {
		return prev;
	}

	public void setPrev(GraphNode prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return this.name.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		GraphNode node = (GraphNode) obj;
		return this.name.equals(node.getName());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	private String getName() {
		return this.name;
	}
}