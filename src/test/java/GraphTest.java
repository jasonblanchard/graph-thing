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

    @Test
    public void toJSON() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        assertEquals("{\"nodes\":[{\"id\":0},{\"id\":1},{\"id\":2},{\"id\":3}],\"edges\":[{\"from\":0,\"to\":1},{\"from\":0,\"to\":2},{\"from\":1,\"to\":0},{\"from\":2,\"to\":0},{\"from\":2,\"to\":3},{\"from\":3,\"to\":2}]}", graph.toJSON());
    }
}
