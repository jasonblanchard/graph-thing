import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Graph {
    private final int V;
    private ArrayList<ArrayList<Integer>> adj; // TODO: Replace with Bag?

    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            this.adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

	public int V() {
		return this.V;
    }

    public int maxEdges() {
        return (this.V() * (this.V() - 1)) / 2;
    }
    
    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public String toJSON() {
        HashMap<String, ArrayList<HashMap<String, Integer>>> object = new HashMap<String, ArrayList<HashMap<String, Integer>>>();
        ArrayList<HashMap<String, Integer>> nodes = new ArrayList<>();
        ArrayList<HashMap<String, Integer>> edges = new ArrayList<>();

        for (int i = 0; i < this.V(); i++) {
            HashMap<String, Integer> node = new HashMap<String, Integer>();
            node.put("id", i);
            nodes.add(node);
        }

        for (int i = 0; i < this.V(); i++) {
            for (int j : this.adj(i)) {
                HashMap<String, Integer> edge = new HashMap<String, Integer>();
                edge.put("from", i);
                edge.put("to", j);
                edges.add(edge);
            }
        }
        
        object.put("nodes", nodes);
        object.put("edges", edges);

        String json = "";
        ObjectWriter ow = new ObjectMapper().writer();
        try {
			json = ow.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
    }
}