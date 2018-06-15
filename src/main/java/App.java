import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		staticFiles.location("public");
		
		get("/ping", (request, res) -> "Pong");

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			for (int i = 0; i < g.V(); i++) {
				for (int j : g.adj(i)) {
					System.out.println(i + "-" + j);
				}
			}
			return new HandlebarsTemplateEngine().render(new ModelAndView(attributes, "index.hbs"));
		});
	}
}