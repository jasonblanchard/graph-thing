import java.util.Stack;

public class DepthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph g, int s) {
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.maxEdges()];
        this.s = s;
        dfs(g, s);
    }

    public int getS() {
        return this.s;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!this.hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
		return path;
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
                edgeTo[w] = v;
            }
        } 
    }
}