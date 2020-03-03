package shortpathtest;

import online.test.shortpathtest.GraphNode;
import online.test.shortpathtest.ShortestPath;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ShortestPathTest {

    Map<String, GraphNode> matrix = new HashMap<>();

    @Before
    public void setup() {
    	
    	newNode("Diego", new GraphNode("Pedro"));
    	newNode("Irina");
    	newNode("Pedro", new GraphNode("Irina"));
    	newNode("Gabi", new GraphNode("Pedro"));
    	newNode("Sol", new GraphNode("Alice"), new GraphNode("Irina"));
    	newNode("Juan", new GraphNode("Wally"));
    	newNode("Alice", new GraphNode("Juan"));
    	newNode("Wally", new GraphNode("Gabi"), new GraphNode("Diego"));
    	newNode("Unknown");
    	
    }
    
    private GraphNode newNode(String name, GraphNode... linkedNodes) {
    	
    	GraphNode newNode = matrix.computeIfAbsent(name, k -> new GraphNode(name));
    	for (GraphNode linkedNode : linkedNodes) {
        	
        	GraphNode newLinkedNode = newNode(linkedNode.toString());
        	newNode.getLinkedNodeList().add(newLinkedNode);
        	newLinkedNode.getLinkedNodeList().add(newNode);
        
        }
        return newNode;
    }
    
    @Test
    public void findShortestPath() {
    	ShortestPath sp = new ShortestPath();
        int shortestPath = sp.getShortestPathDistance(new GraphNode("Diego"), new GraphNode("Alice"), matrix);
        assertThat(shortestPath, equalTo(3));
    }

    @Test
    public void findAnotherShortestPath() {
    	ShortestPath sp = new ShortestPath();
        int shortestPath = sp.getShortestPathDistance(new GraphNode("Juan"), new GraphNode("Irina"), matrix);
        assertThat(shortestPath, equalTo(3));
    }
    
    @Test
    public void findNoPath() {
    	ShortestPath sp = new ShortestPath();
        int shortestPath = sp.getShortestPathDistance(new GraphNode("Diego"), new GraphNode("Unknown"), matrix);
        assertThat(shortestPath, equalTo(-1));
    }
    
    @Test
    public void findShortestPathWallyToSol() {
    	ShortestPath sp = new ShortestPath();
        int shortestPath = sp.getShortestPathDistance(new GraphNode("Wally"), new GraphNode("Sol"), matrix);
        assertThat(shortestPath, equalTo(3));
    }
    
    @Test
    public void findShortestPathJuanToDiego() {
    	ShortestPath sp = new ShortestPath();
        int shortestPath = sp.getShortestPathDistance(new GraphNode("Juan"), new GraphNode("Diego"), matrix);
        assertThat(shortestPath, equalTo(2));
    }
    
    @Test
    public void findShortestPathIrinaToSol() {
    	ShortestPath sp = new ShortestPath();
        int shortestPath = sp.getShortestPathDistance(new GraphNode("Irina"), new GraphNode("Sol"), matrix);
        assertThat(shortestPath, equalTo(1));
    }
    
    @Test
    public void findShortestPathFindingMyself() {
    	ShortestPath sp = new ShortestPath();
        int shortestPath = sp.getShortestPathDistance(new GraphNode("Sol"), new GraphNode("Sol"), matrix);
        assertThat(shortestPath, equalTo(0));
    }
    
}
