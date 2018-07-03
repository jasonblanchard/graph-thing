import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		staticFiles.location("public");
		
		get("/ping", (request, res) -> "Pong");

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			Graph graph = new Graph(10);
			graph.addEdge(0, 3);
			graph.addEdge(0, 1);
			graph.addEdge(1, 2);
			graph.addEdge(2, 3);
			graph.addEdge(2, 5);
			graph.addEdge(8, 4);
			graph.addEdge(7, 1);
			graph.addEdge(4, 7);
			graph.addEdge(8, 6);
			graph.addEdge(6, 2);

			// Graph graph = new Graph(4);
			// graph.addEdge(0, 1);
			// graph.addEdge(0, 2);
			// graph.addEdge(2, 3);

			int from = 2;
			int to = 4;
			// // DepthFirstPaths paths = new DepthFirstPaths(graph, from);
			BreadthFirstPaths paths = new BreadthFirstPaths(graph, from);
			Iterable<Integer> path = paths.hasPathTo(to) ? paths.pathTo(to) : new Stack<Integer>();
			attributes.put("path", path);
			attributes.put("from", from);
			attributes.put("to", to);

			attributes.put("graph", graph.toJSON());
			System.out.println(graph.toJSON());
			return new HandlebarsTemplateEngine().render(new ModelAndView(attributes, "index.hbs"));
		});
	}
}