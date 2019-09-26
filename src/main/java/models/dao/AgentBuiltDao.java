package models.dao;

import models.Agent;
import models.AgentBuilt;
import models.Built;

import java.util.List;

public interface AgentBuiltDao {


    void add(AgentBuilt agentbuilt);

    List<AgentBuilt> getAll();

    Built findById(int id);

    void deleteById(int id);

    void clearAll();

    void update(int id, String built_name, String built_description, String built_location, int built_price, String type, String purpose, String contact, int agent_id);

    Agent getAgentForBuilt (AgentBuilt agentBuilt);


}
