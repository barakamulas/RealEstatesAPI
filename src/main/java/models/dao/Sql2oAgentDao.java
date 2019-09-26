package models.dao;

import models.Agent;
import models.AgentBuilt;
import models.dao.AgentDao;
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
    public void update(int id,String newAgent_name, String newContact, String newAgent_reviews){
        String sql = "UPDATE agents SET agent_name =:agent_name , contact =:contact, agent_reviews =:agent_reviews WHERE id =:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("agent_name", newAgent_name)
                    .addParameter("id",id)
                    .addParameter("contact", newContact)
                    .addParameter("agent_reviews", newAgent_reviews)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
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

    @Override
    public List<AgentBuilt> getAllBuiltsForAgent(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM agentbuilts WHERE agent_id = :agent_id")
                    .addParameter("agent_id", id)
                    .executeAndFetch(AgentBuilt.class);
        }
    }


}
