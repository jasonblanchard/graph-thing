import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BreadthFirstPathsTest {
    @Test
    public void hasPathFor() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
        assertEquals(true, paths.hasPathTo(1));
        assertEquals(true, paths.hasPathTo(2));
        assertEquals(true, paths.hasPathTo(3));
    }

    @Test
    public void hasPathToFalse() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
        assertEquals(false, paths.hasPathTo(3));
    }

    @Test
    public void pathToNull() {
        Graph graph = new Graph(4);
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
        assertEquals(null, paths.pathTo(2));
    }

    @Test
    public void pathTo() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
        String s = "";

        assertEquals(true, paths.pathTo(3) != null);

        for (int v : paths.pathTo(3)) {
            s = s + ',' + v;
        }
        
        assertEquals(",3,2,0", s);
    }

    @Test
    public void distTo() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
        assertEquals(1, paths.distTo(2));
        assertEquals(2, paths.distTo(3));
        assertEquals(3, paths.distTo(4));
    }
}
