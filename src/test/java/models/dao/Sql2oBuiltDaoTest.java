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
    private Sql2oBuiltDao builtDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        builtDao = new Sql2oBuiltDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

//    @Test
//    public void addingFoodSetsId() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        assertNotEquals(0, testRestaurant.getId());
//    }
//
//    @Test
//    public void addedRestaurantsAreReturnedFromGetAll() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        assertEquals(1, restaurantDao.getAll().size());
//    }
//
//    @Test
//    public void noRestaurantsReturnsEmptyList() throws Exception {
//        assertEquals(0, restaurantDao.getAll().size());
//    }
//
//    @Test
//    public void findByIdReturnsCorrectRestaurant() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        Restaurant otherRestaurant = setupRestaurant();
//        assertEquals(testRestaurant, restaurantDao.findById(testRestaurant.getId()));
//    }
//
//    @Test
//    public void updateCorrectlyUpdatesAllFields() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        restaurantDao.update(testRestaurant.getId(), "a", "b", "c", "d", "e", "f");
//        Restaurant foundRestaurant = restaurantDao.findById(testRestaurant.getId());
//        assertEquals("a", foundRestaurant.getName());
//        assertEquals("b", foundRestaurant.getAddress());
//        assertEquals("c", foundRestaurant.getZipcode());
//        assertEquals("d", foundRestaurant.getPhone());
//        assertEquals("e", foundRestaurant.getWebsite());
//        assertEquals("f", foundRestaurant.getEmail());
//    }
//
//    @Test
//    public void deleteByIdDeletesCorrectRestaurant() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        Restaurant otherRestaurant = setupRestaurant();
//        restaurantDao.deleteById(testRestaurant.getId());
//        assertEquals(1, restaurantDao.getAll().size());
//    }
//
//    @Test
//    public void clearAll() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        Restaurant otherRestaurant = setupRestaurant();
//        restaurantDao.clearAll();
//        assertEquals(0, restaurantDao.getAll().size());
//    }
//
//    public Foodtype setupNewFoodtype() {
//        return new Foodtype("Sushi");
//    }
//
//    public Built setupBuilt (){
//        Built testBuilt = new Built("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222");
//        builtDao.add(testBuilt);
//        return testBuilt;
//    }
//
//    public Built setupAltBuilt (){
//        Built altBuilt = new Built("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222");
//        builtDao.add(altBuilt);
//        return altBuilt;
//    }

}