package models;

import java.util.Objects;

public class AgentBuilt extends Built{

    private int agent_id;

    public AgentBuilt(String built_name, String built_description, String built_location, int built_price, String type, String purpose, String contact, int agent_id) {
        super(built_name, built_description, built_location, built_price, type, purpose, contact);
        this.agent_id = agent_id;
    }

    public int getAgent_id() { return agent_id; }

    public void setAgent_id(int agent_id) { this.agent_id = agent_id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AgentBuilt that = (AgentBuilt) o;
        return getAgent_id() == that.getAgent_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAgent_id());
    }
}
