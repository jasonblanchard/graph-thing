import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;
    private ArrayList<List<Integer>> adj; // TODO: Replace with Bag?

    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < V; i++) {
            this.adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

	public int V() {
		return V;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }
}