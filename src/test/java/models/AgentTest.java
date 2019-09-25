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
    public Agent setUpAnotherAgent(){
        Agent agent = new Agent("Fiane Makanja","+255 758 993 875","Amazing customer experience");
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
    @Test
    public void addAgent_getAgentReview() throws Exception{
        Agent agent = setUpNewAgent();
        assertEquals("She is great",agent.getAgent_reviews());
    }
    @Test
    public void addAgent_getsTheCorrectName(){
        Agent agent = setUpNewAgent();
        assertNotEquals("Diana",agent.getAgent_name());
    }
    @Test
    public  void addAgent_getsTheCorrectContact() throws Exception{
        Agent agent = setUpNewAgent();
        assertNotEquals("0734 567 345",agent.getContact());
    }
    @Test
    public void addAgent_getsTheCorrectReview() throws Exception{
        Agent agent = setUpNewAgent();
        assertNotEquals("Bad fruit in the making",agent.getAgent_reviews());
    }
    @Test
    public void addAgent_getsCorrectAgent()throws Exception{
        Agent agent = setUpNewAgent();
        Agent anotherAgent = setUpNewAgent();
        assertTrue(agent.equals(anotherAgent));
    }
    @Test
    public void addAgent_showsIfTheCorrectAgentHasBeenAdded() throws Exception{
        Agent agent = setUpNewAgent();
        Agent anotherAgent = setUpAnotherAgent();
        assertFalse(agent.equals(anotherAgent));
    }

}