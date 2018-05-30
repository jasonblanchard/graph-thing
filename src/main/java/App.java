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
			return new HandlebarsTemplateEngine().render(new ModelAndView(attributes, "index.hbs"));
		});
	}
}