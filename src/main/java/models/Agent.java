package models;

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
}
