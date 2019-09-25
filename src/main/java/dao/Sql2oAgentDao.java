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
        return null;
    }

    @Override
    public Agent findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}