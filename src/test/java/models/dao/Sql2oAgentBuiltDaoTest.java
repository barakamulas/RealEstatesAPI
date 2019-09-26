package models.dao;

import models.AgentBuilt;
import models.Built;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oAgentBuiltDaoTest {

    private Connection conn;
    private models.dao.Sql2oAgentBuiltDao agentBuiltDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        agentBuiltDao = new models.dao.Sql2oAgentBuiltDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingAgentBuiltSetsId() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertNotEquals(0, testAgentBuilt.getId());
    }

    @Test
    public void addedAgentBuiltsAreReturnedFromGetAll() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals(1, agentBuiltDao.getAll().size());
    }

    @Test
    public void noAgentBuiltsReturnsEmptyList() throws Exception {
        assertEquals(0, agentBuiltDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectAgentBuilt() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        AgentBuilt otherAgentBuilt = setupAgentBuilt();
        assertEquals(testAgentBuilt , agentBuiltDao.findById(testAgentBuilt .getId()));
    }


    @Test
    public void deleteByIdDeletesCorrectAgentBuilt() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        AgentBuilt otherAgentBuilt = setupAltAgentBuilt();
        agentBuiltDao.deleteById(testAgentBuilt .getId());
        assertEquals(1, agentBuiltDao.getAll().size());
    }

//    @Test
//    public void clearAll() throws Exception {
//        AgentBuilt testAgentBuilt = setupAgentBuilt();
//        AgentBuilt otherAgentBuilt = setupAgentBuilt();
//        agentBuiltDao.clearAll();
//        assertEquals(0, agentBuiltDao.getAll().size());
//    }
//
//
//    @Test
//    public void updateCorrectlyUpdatesAllFields() throws Exception {
//        AgentBuilt testAgentBuilt = setupAgentBuilt();
//        agentBuiltDao.update(testAgentBuilt .getId(), "a", "b", "c", 1000000, "For Sale", "Commercial", "+254744444444");
//        AgentBuilt foundAgentBuilt = agentBuiltDao.findById(testAgentBuilt .getId());
//        assertEquals("a", foundAgentBuilt .getBuilt_name());
//        assertEquals("b", foundAgentBuilt .getBuilt_description());
//        assertEquals("c", foundAgentBuilt .getBuilt_location());
//        assertEquals("For Sale", foundAgentBuilt .getType());
//        assertEquals("Commercial", foundAgentBuilt .getPurpose());
//        assertEquals("+254744444444", foundAgentBuilt .getContact());
//    }


    public AgentBuilt setupAgentBuilt (){
        AgentBuilt testAgentBuilt = new AgentBuilt("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222",1);
        agentBuiltDao.add(testAgentBuilt);
        return testAgentBuilt;
    }

    public AgentBuilt setupAltAgentBuilt (){
        AgentBuilt altAgentBuilt = new AgentBuilt("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222",1);
        agentBuiltDao.add(altAgentBuilt);
        return altAgentBuilt;
    }

    public AgentBuilt setupThirdAgentBuilt (){
        AgentBuilt thirdAgentBuilt = new AgentBuilt("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222221",1);
        agentBuiltDao.add(thirdAgentBuilt);
        return thirdAgentBuilt;

    }




}