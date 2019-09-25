package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    public Agent setUpNewAgent(){
        Agent agent = new Agent("Maria Kamau","+254 723 456 789","She is great");
        return agent;
    }
    @Test
    public void addAgent_seeAgent() throws Exception{
        Agent agent = setUpNewAgent();
        assertTrue(agent instanceof Agent);
    }
    @Test
    public void addAgent_getName()throws Exception{
        Agent agent = setUpNewAgent();
        assertEquals("Maria Kamau",agent.getAgent_name());
    }
    @Test
    public void addAgent_getContact() throws Exception{
        Agent agent = setUpNewAgent();
        assertEquals("+254 723 456 789",agent.getContact());
    }
}