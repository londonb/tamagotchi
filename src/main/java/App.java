import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/name.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/home",(request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();


      String name = request.queryParams("petName");
      Tamagotchi myTamagotchi = new Tamagotchi(name);
      request.session().attribute("Tamagotchi", myTamagotchi);
      int activity = myTamagotchi.getActivityLevel();
      int food = myTamagotchi.getFoodLevel();
      int sleep = myTamagotchi.getSleepLevel();
      int health = myTamagotchi.getHealthLevel();

      model.put("name", name);
      model.put("activity", activity);
      model.put("food", food);
      model.put("sleep", sleep);
      model.put("health", health);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Tamagotchi myTamagotchi = request.session().attribute("Tamagotchi");

      myTamagotchi.timePasses();

      //integer int string problem remains

      for (int i=1; i <= int.parseInt(request.queryParams("feed")); i++) {
        myTamagotchi.feed();
      }
      for (int i=1; i <= int.parseInt(request.queryParams("play")); i++) {
        myTamagotchi.feed();
      }
      for (int i=1; i <= int.parseInt(request.queryParams("nap")); i++) {
        myTamagotchi.feed();
      }

      request.session().attribute("Tamagotchi", myTamagotchi);

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
