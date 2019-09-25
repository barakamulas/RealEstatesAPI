package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellingTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Selling setUpNewLand(){
        Selling selling  = new Selling("Makulos","desc","for lease",100000,"commercial","+453261","Makueni",2);
        return selling;
    }

    @Test
    public void Selling_instantiatesCorrectly() {
        assertTrue(setUpNewLand()instanceof Selling);
    }


}