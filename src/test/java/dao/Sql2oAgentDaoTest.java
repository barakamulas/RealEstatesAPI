package dao;

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
        return agent;
    }
    public Agent setUpAnotherAgent(){
        Agent agent = new Agent("Fiane Makanja","+255 758 993 875","Amazing customer experience");
        return agent;
    }
    @Test
    public void addAgent_getsId() throws Exception{
        Agent agent = setUpNewAgent();
        agentDao.add(agent);
        assertEquals(1,agent.getId());
    }
    @Test
    public void addAgent_getsAllAgents() throws Exception{
        Agent agent = setUpNewAgent();
        agentDao.add(agent);
        Agent anotherAgent = setUpAnotherAgent();
        agentDao.add(anotherAgent);
        assertEquals(2,agentDao.getAgents().size());

    }
}