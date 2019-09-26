import models.dao.Sql2oAgentDao;
import models.dao.Sql2oBuiltDao;
import models.dao.Sql2oSellingDao;
import models.Selling;
import models.Agent;
import models.Built;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
      staticFileLocation("/public");
      Sql2oBuiltDao builtDao;
      Sql2oSellingDao sellingDao;
      Sql2oAgentDao agentDao;
      Connection conn;
      Gson gson = new Gson();

      String connectionString = "jdbc:h2:~/realestatesapi.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
      Sql2o sql2o = new Sql2o(connectionString,"","");




        builtDao = new Sql2oBuiltDao(sql2o);
        sellingDao = new Sql2oSellingDao(sql2o);
        agentDao = new Sql2oAgentDao(sql2o);
        conn = sql2o.open();

      
          get("/",(req,res)->{
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
          },new HandlebarsTemplateEngine());
        

          get("/api/built","application/json",(request, response) -> {
              response.type("application/json");
              return gson.toJson(builtDao.getAll());
          });
          get("/api/selling","application/json",(request, response) -> {
              response.type("application/json");
              return gson.toJson(sellingDao.all());
          });
          get("/api/agents","application/json",(request, response) -> {
              response.type("application/json");
              return gson.toJson(agentDao.getAgents());
          });
          get("/api/agents/:id","application/json",(request, response) -> {
              int agentId = Integer.parseInt(request.params("id"));
              response.type("application/json");
              return gson.toJson(agentDao.findById(agentId));
          });
          get("/api/selling/:id","application/json",(request, response) -> {
              int sellingId = Integer.parseInt(request.params("id"));
              response.type("application/json");
              return gson.toJson(sellingDao.findById(sellingId));
          });
          get("/api/built/:id","application/json",(request, response) -> {
              int builtId = Integer.parseInt(request.params("id"));
              response.type("application/json");
              return gson.toJson(builtDao.findById(builtId));
          });
          post("/api/built/new","application/json",(request, response) -> {
              Built built = gson.fromJson(request.body(),Built.class);
              builtDao.add(built);
              response.status(201);
              response.type("application/json");
              return gson.toJson(built);
          });
          post("/api/selling/new","application/json",(request, response) -> {
              Selling selling = gson.fromJson(request.body(),Selling.class);
              sellingDao.add(selling);
              response.status(201);
              response.type("application/json");
              return gson.toJson(selling);
          });
          post("/api/agents/new","application/json",(request, response) -> {
              Agent agent = gson.fromJson(request.body(),Agent.class);
              agentDao.add(agent);
              response.status(201);
              response.type("application/json");
              return gson.toJson(agent);
          });
    }
}
