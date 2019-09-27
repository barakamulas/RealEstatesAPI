import models.*;
import models.dao.Sql2oAgentBuiltDao;
import models.dao.Sql2oAgentDao;
import models.dao.Sql2oBuiltDao;
import models.dao.Sql2oSellingDao;
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
      Sql2oAgentBuiltDao agentBuiltDao;
      Connection conn;
      Gson gson = new Gson();

      String connectionString = "jdbc:h2:~/realestatesapi.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
      Sql2o sql2o = new Sql2o(connectionString,"","");




        agentBuiltDao = new Sql2oAgentBuiltDao(sql2o);

        builtDao = new Sql2oBuiltDao(sql2o);
        sellingDao = new Sql2oSellingDao(sql2o);
        agentDao = new Sql2oAgentDao(sql2o);
        conn = sql2o.open();
        Map<String,Object> model = new HashMap<>();

         get("/",(req,res)->{
             model.put("sellings", sellingDao.all());
             model.put("builts",builtDao.getAll());
             model.put("agents",agentDao.getAgents());
             model.put("agentbuilts",agentBuiltDao.getAll());
            return new ModelAndView(model,"index.hbs");
         },new HandlebarsTemplateEngine());


        get("/apis",(request, response) -> {
            model.put("sellings", sellingDao.all());
            model.put("builts",builtDao.getAll());
            model.put("agents",agentDao.getAgents());
            model.put("agentbuilts",agentBuiltDao.getAll());
            return new ModelAndView(model,"api.hbs");
        },new HandlebarsTemplateEngine());

         get("/builts/new",(request, response) -> {
             model.put("sellings", sellingDao.all());
             model.put("ForSale", Constant.FOR_SALE);
             model.put("ToLet", Constant.TO_LET);
             model.put("Commercial", Constant.COMMERCIAL);
             model.put("Residential", Constant.RESIDENTIAL);
             model.put("Industrial", Constant.INDUSTRIAL);
             model.put("Special", Constant.SPECIAL);
             model.put("built", true);
             return new ModelAndView(model,"built-form.hbs");
                },new HandlebarsTemplateEngine());

         get("/agentbuilts/new",(request, response) -> {

              model.put("ForSale", Constant.FOR_SALE);
              model.put("ToLet", Constant.TO_LET);
              model.put("Commercial", Constant.COMMERCIAL);
              model.put("Residential", Constant.RESIDENTIAL);
              model.put("Industrial", Constant.INDUSTRIAL);
              model.put("Special", Constant.SPECIAL);
              return new ModelAndView(model,"agentbuilt-form.hbs");
          },new HandlebarsTemplateEngine());

        post("/agentbuilts/new",(request, response) -> {
            String built_name = request.queryParams("name");
            String built_description = request.queryParams("description");
            String built_location = request.queryParams("location");
            int built_price = Integer.parseInt(request.queryParams("price"));
            String type = request.queryParams("type");
            String purpose = request.queryParams("purpose");
            String contact = request.queryParams("contact");
            String agent_name = request.queryParams("agent_name");
            String agent_contact = request.queryParams("agent_contact");
            Agent newAgent = new Agent(agent_name,agent_contact,"Good");
            agentDao.add(newAgent);
            AgentBuilt newAgentBuilt = new AgentBuilt(built_name,built_description,built_location,built_price,type,purpose,contact,newAgent.getId());
            agentBuiltDao.add(newAgentBuilt);
            model.put("sellings", sellingDao.all());
            model.put("builts",builtDao.getAll());
            model.put("agents",agentDao.getAgents());
            model.put("agentbuilts",agentBuiltDao.getAll());
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());



          get("/agentform",(request, response) -> {
              return new ModelAndView(model,"agentform.hbs");
          },new HandlebarsTemplateEngine());

          get("/sellingform",(request, response) -> {
            return new ModelAndView(model,"sellingform.hbs");
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
            post("/builts/new",(request, response) -> {
                String built_name = request.queryParams("name");
                String built_description = request.queryParams("description");
                String built_location = request.queryParams("location");
                int built_price = Integer.parseInt(request.queryParams("price"));
                String type = request.queryParams("type");
                String purpose = request.queryParams("purpose");
                String contact = request.queryParams("contact");
                Built newBuilt = new Built(built_name,built_description,built_location,built_price,type,purpose,contact);
                builtDao.add(newBuilt);
                response.redirect("/");
                return null;
            },new HandlebarsTemplateEngine());

            post("/agentbuilts/new",(request, response) -> {
                String built_name = request.queryParams("name");
                String built_description = request.queryParams("description");
                String built_location = request.queryParams("location");
                int built_price = Integer.parseInt(request.queryParams("price"));
                String type = request.queryParams("type");
                String purpose = request.queryParams("purpose");
                String contact = request.queryParams("contact");
                String agent_name = request.queryParams("agent_name");
                String agent_contact = request.queryParams("agent_contact");
                Agent newAgent = new Agent(agent_name,agent_contact,"Good");
                agentDao.add(newAgent);
                AgentBuilt newAgentBuilt = new AgentBuilt(built_name,built_description,built_location,built_price,type,purpose,contact,newAgent.getId());
                agentBuiltDao.add(newAgentBuilt);
                model.put("sellings", sellingDao.all());
                model.put("builts",builtDao.getAll());
                model.put("agents",agentDao.getAgents());
                model.put("agentbuilts",agentBuiltDao.getAll());
                response.redirect("/");
                return null;
        },new HandlebarsTemplateEngine());
    }

}
