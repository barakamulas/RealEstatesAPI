package models.dao;

import models.Built;
import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.Test;
import static org.junit.Assert.*;


public class Sql2oBuiltDaoTest {

    private Connection conn;
    private models.dao.Sql2oBuiltDao builtDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        builtDao = new models.dao.Sql2oBuiltDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingBuiltSetsId() throws Exception {
        Built testBuilt = setupBuilt();
        assertNotEquals(0, testBuilt.getId());
    }

    @Test
    public void addedBuiltsAreReturnedFromGetAll() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals(1, builtDao.getAll().size());
    }

    @Test
    public void noBuiltsReturnsEmptyList() throws Exception {
        assertEquals(0, builtDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectBuilt() throws Exception {
        Built testBuilt = setupBuilt();
        Built otherBuilt = setupBuilt();
        assertEquals(testBuilt, builtDao.findById(testBuilt.getId()));
    }


    @Test
    public void deleteByIdDeletesCorrectBuilt() throws Exception {
        Built testBuilt = setupBuilt();
        Built otherBuilt = setupAltBuilt();
        builtDao.deleteById(testBuilt.getId());
        assertEquals(1, builtDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Built testBuilt = setupBuilt();
        Built otherBuilt = setupBuilt();
        builtDao.clearAll();
        assertEquals(0, builtDao.getAll().size());
    }


    @Test
    public void updateCorrectlyUpdatesAllFields() throws Exception {
        Built testBuilt = setupBuilt();
        builtDao.update(testBuilt.getId(), "a", "b", "c", 1000000, "For Sale", "Commercial", "+254744444444");
        Built foundBuilt = builtDao.findById(testBuilt.getId());
        assertEquals("a", foundBuilt.getBuilt_name());
        assertEquals("b", foundBuilt.getBuilt_description());
        assertEquals("c", foundBuilt.getBuilt_location());
        assertEquals("For Sale", foundBuilt.getType());
        assertEquals("Commercial", foundBuilt.getPurpose());
        assertEquals("+254744444444", foundBuilt.getContact());
    }




    public Built setupBuilt (){
        Built testBuilt = new Built("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222");
        builtDao.add(testBuilt);
        return testBuilt;
    }

    public Built setupAltBuilt (){
        Built altBuilt = new Built("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222");
        builtDao.add(altBuilt);
        return altBuilt;
    }

}