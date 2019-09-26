package models.dao;

import models.Agent;
import models.AgentBuilt;

import java.util.List;

public interface AgentDao {

    void add(Agent agent);

    List<Agent> getAgents();

    Agent findById(int id);

    void update(int id,String agent_name,String contact,String agent_reviews);

    void deleteById(int id);

    void clearAll();

    List<AgentBuilt>getAllBuiltsForAgent(int id);
}
