import models.dao.Sql2oAgentDao;
import models.dao.Sql2oBuiltDao;
import models.dao.Sql2oSellingDao;
import models.Selling;
import models.Agent;
import models.Built;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
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

          get("/built","application/json",(request, response) -> {
            return gson.toJson(builtDao.getAll());
          });
          get("/selling","application/json",(request, response) -> {
              return gson.toJson(sellingDao.all());
          });
          get("/agents","application/json",(request, response) -> {
              return gson.toJson(agentDao.getAgents());
          });
          get("/agents/:id","application/json",(request, response) -> {
            int agentId = Integer.parseInt(request.params("id"));
            return gson.toJson(agentDao.findById(agentId));
          });
          get("/selling/:id","application/json",(request, response) -> {
            int sellingId = Integer.parseInt(request.params("id"));
            return gson.toJson(sellingDao.findById(sellingId));
          });
          get("/built/:id","application/json",(request, response) -> {
            int builtId = Integer.parseInt(request.params("id"));
            return gson.toJson(builtDao.findById(builtId));
          });
    }
}
