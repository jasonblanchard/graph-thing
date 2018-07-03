import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int s;
    private Queue<Integer> queue = new LinkedList<Integer>();
    
    public BreadthFirstPaths(Graph g, int s) {
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.maxEdges()];
        this.distTo = new int[g.V()];
        this.s = s;

        queue.add(s);

        int dist = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (!marked[i]) {
                if (queue.isEmpty()) dist += 1;

                for (int j : g.adj(i)) {
                    if (!marked[j]) {
                        edgeTo[j] = i;
                        distTo[j] = dist;
                        if (!marked[j]) queue.add(j);
                    }
                }
                marked[i] = true;
            }
        }
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

    public int distTo(int v) {
        return distTo[v];
    }
}