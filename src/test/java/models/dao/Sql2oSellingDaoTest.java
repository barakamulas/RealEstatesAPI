package models.dao;

import models.Selling;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oSellingDaoTest {
    private Connection conn;
    private Sql2oSellingDao sellingDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        sellingDao = new Sql2oSellingDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Selling setUpNewLand(){
        Selling selling  = new Selling("Makulos","desc","for lease",100000,"commercial","+453261","Makueni",2);
        sellingDao.add(selling);
        return selling;
    }

    @Test
    public void addingLandInstanceSetsId_true()throws Exception {
        assertEquals(1,setUpNewLand().getId());
    }

    @Test
    public void all_returnsAllLandEntries()throws Exception {
        Selling firstLand = setUpNewLand();
        Selling secondLand = setUpNewLand();
        assertEquals(2,sellingDao.all().size());

    }

    @Test
    public void findById_returnsLandById_true() {
        Selling testLand = setUpNewLand();
        Selling otherLand = setUpNewLand();
        assertEquals(otherLand,sellingDao.findById(otherLand.getId()));
    }

//    @Test
//    public void name() {
//    }
}