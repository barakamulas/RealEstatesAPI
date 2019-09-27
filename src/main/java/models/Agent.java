package models;

import java.util.Objects;

public class Agent {
    private String agent_name;
    private String contact;
    private String agent_reviews;
    private int id;

    public Agent(String agent_name,String contact,String agent_reviews) {
        this.contact = contact;
        this.agent_name = agent_name;
        this.agent_reviews = agent_reviews;
        this.id = id;
    }

    public Agent(String agent_name,String contact) {
        this.contact = contact;
        this.agent_name = agent_name;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAgent_reviews() {
        return agent_reviews;
    }

    public void setAgent_reviews(String agent_reviews) {
        this.agent_reviews = agent_reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return getId() == agent.getId() &&
                Objects.equals(getAgent_name(), agent.getAgent_name()) &&
                Objects.equals(getContact(), agent.getContact()) &&
                Objects.equals(getAgent_reviews(), agent.getAgent_reviews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAgent_name(), getContact(), getAgent_reviews(), getId());
    }
}
