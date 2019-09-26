package models.dao;

import dao.Sql2oAgentDao;
import models.Agent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oAgentDaoTest {
    private Connection conn;
    private Sql2oAgentDao agentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        agentDao = new Sql2oAgentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Agent setUpNewAgent(){
        Agent agent = new Agent("Maria Kamau","+254 723 456 789","She is great");
        agentDao.add(agent);
        return agent;
    }
    public Agent setUpAnotherAgent(){
        Agent otherAgent = new Agent("Fiane Makanja","+255 758 993 875","Amazing customer experience");
        agentDao.add(otherAgent);
        return otherAgent;
    }
    @Test
    public void addAgent_getsId() throws Exception{
        Agent agent = setUpNewAgent();
        assertEquals(1,agent.getId());
    }
    @Test
    public void addAgent_getsAllAgents() throws Exception{
        Agent agent = setUpNewAgent();
        Agent anotherAgent = setUpAnotherAgent();
        assertEquals(2,agentDao.getAgents().size());
    }
    @Test
    public void haveAgent_findsAgentById() throws Exception{
        Agent agent = setUpNewAgent();
        assertEquals(agentDao.findById(agent.getId()), agent);
    }

    @Test
    public void haveAgent_updatesAgent(){
        Agent agent = setUpNewAgent();
        agentDao.update(agent.getId(),"Meghan","+255 768 342 564","Terrific:Always ready to listen to customers");
        Agent updatedAgent = agentDao.findById(agent.getId());
        assertNotEquals(agent, updatedAgent);
    }
    @Test
    public void haveAgent_deletesAgentById() throws Exception {
        Agent agent = setUpNewAgent();
        Agent otherAgent = setUpAnotherAgent();
        assertEquals(2, agentDao.getAgents().size());
        agentDao.deleteById(agent.getId());
        assertEquals(1, agentDao.getAgents().size());
    }

    @Test
    public void haveAgents_clearAllAgents() throws Exception{
        Agent agent = setUpNewAgent();
        Agent otherAgent = setUpAnotherAgent();
        agentDao.clearAll();
        assertEquals(0,agentDao.getAgents().size());
    }
}