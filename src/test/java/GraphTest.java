import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GraphTest {
    @Test
    public void V() {
        Graph graph = new Graph(4);
        assertEquals(4, graph.V());
    }

    @Test
    public void addingEdges() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        assertEquals("1", graph.adj(0).iterator().next().toString());
        assertEquals("0", graph.adj(1).iterator().next().toString());
    }
}
