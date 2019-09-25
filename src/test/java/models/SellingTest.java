package models;
import java.math.*;

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
    //set up a new land instance
    public Selling setUpNewLand(){
        Selling selling  = new Selling("Makulos","desc","for lease",100000,"commercial","+453261","Makueni",2);
        return selling;
    }

    //tests for getter methods
    @Test
    public void Selling_instantiatesCorrectly() {
        assertTrue(setUpNewLand()instanceof Selling);
    }


    @Test
    public void getLand_name_SellingInstantiatesWithLandName_true() {
        assertEquals("Makulos",setUpNewLand().getLand_name());
    }

    @Test
    public void getLand_description_SellingInstantiatesWithLandDescription_true() {
        assertEquals("desc",setUpNewLand().getLand_description());
    }

    @Test
    public void getLand_type_SellingInstantiatesWithLandType_true() {
        assertEquals("for lease",setUpNewLand().getSelling_type());
    }

    @Test
    public void getLand_price_SellingInstantiatesWithLandPrice_true() {
        assertEquals(100000,setUpNewLand().getLand_price());
    }

    @Test
    public void getPurpose_SellingInstantiatesWithLandPurpose_true() {
        assertEquals("commercial",setUpNewLand().getPurpose());
    }

    @Test
    public void getContact_SellingInstantiatesWithContact_true() {
        assertEquals("+453261",setUpNewLand().getContact());
    }
    @Test
    public void getLand_loaction_SellingInstantiatesWithLandLocation_true() {
        assertEquals("+453261",setUpNewLand().getContact());
    }

    @Test
    public void getSize_SellingInstantiatesWithLandSize_true() {
        assertEquals(2,setUpNewLand().getSize());
    }

    //test for equals override
    @Test
    public void equals_returnsTrueIfTwoEntriesAreSame_true() {
        Selling firstLand = setUpNewLand();
        Selling secondLand = setUpNewLand();

        assertTrue(firstLand.equals(secondLand));
    }
}