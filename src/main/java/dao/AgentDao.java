package dao;

import models.Agent;

import java.util.List;

public interface AgentDao {
    void add(Agent agent);

    List<Agent> getAgents();

    Agent findById(int id);

    void deleteById(int id);
    void clearAll();
}
