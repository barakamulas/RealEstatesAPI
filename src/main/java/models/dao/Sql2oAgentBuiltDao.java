package models.dao;

import models.AgentBuilt;
import models.Built;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAgentBuiltDao implements AgentBuiltDao {

    private final Sql2o sql2o;
    public Sql2oAgentBuiltDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(AgentBuilt agentBuilt) {
        String sql = "INSERT INTO agentbuilts (built_name, built_description, built_location, built_price, type, purpose, contact, agent_id) VALUES (:built_name, :built_description, :built_location, :built_price, :type, :purpose, :contact, :agent_id)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(agentBuilt)
                    .executeUpdate()
                    .getKey();
            agentBuilt.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<AgentBuilt> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM agentbuilts")
                    .executeAndFetch(AgentBuilt.class);
        }
    }



    @Override
    public AgentBuilt findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM agentbuilts WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(AgentBuilt.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from agentbuilts WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from agentbuilts";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void update(int id, String built_name, String built_description, String built_location, int built_price, String type, String purpose, String contact, int agent_id) {
        String sql = "UPDATE agentbuilts SET built_name = :built_name,  built_description= :built_description, built_location = :built_location, built_price = :built_price, type = :type, purpose = :purpose, contact = :contact, agent_id = :agent_id WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("built_name",built_name)
                    .addParameter("built_description", built_description)
                    .addParameter("built_location", built_location)
                    .addParameter("built_price", built_price)
                    .addParameter("type", type)
                    .addParameter("purpose", purpose)
                    .addParameter("contact", contact)
                    .addParameter("agent_id", agent_id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
