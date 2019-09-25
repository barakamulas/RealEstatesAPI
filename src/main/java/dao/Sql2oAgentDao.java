package dao;

import models.Agent;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAgentDao implements AgentDao {

    private final Sql2o sql2o;
    public Sql2oAgentDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Agent agent) {
        String sql = "INSERT INTO agents(agent_name,contact,agent_reviews) VALUES (:agent_name,:contact,:agent_reviews)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(agent)
                    .executeUpdate()
                    .getKey();
           agent.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Agent> getAgents() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM agents")
                    .executeAndFetch(Agent.class);
        }
    }

    @Override
    public Agent findById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM agents where id=:id";
            Agent agent = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Agent.class);
            return agent;
        }
    }

    @Override
    public void deleteById(int id){
        String sql ="DELETE FROM agents WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex) {
           System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from agents";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }


    }
}
