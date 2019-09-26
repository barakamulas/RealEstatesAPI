package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuiltTest {


    @Test
    public void getBuilt_nameReturnsCorrectBuilt_name() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals("Kasuku Centre Lounge", testBuilt.getBuilt_name());
    }

    @Test
    public void getTypeReturnsCorrectType() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals("For Sale", testBuilt.getType());
    }

    @Test
    public void getBuiltDescriptionReturnsCorrectDescription() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals("Single floor Bar and Lounge", testBuilt.getBuilt_description());
    }
    @Test
    public void getBuilt_priceReturnsCorrectBuilt_price() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals(20000000, testBuilt.getBuilt_price());
    }

    @Test
    public void getPurposeReturnsCorrectPurpose() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals("Commercial", testBuilt.getPurpose());
    }

    @Test
    public void getContactReturnsCorrectContact() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals("+254722222222", testBuilt.getContact());
    }


    @Test
    public void getLocationReturnsCorrectLocation() throws Exception {
        Built testBuilt = setupBuilt();
        assertEquals("Kileleshwa", testBuilt.getBuilt_location());
    }


//    ................................................................Setters


    @Test
    public void setBuilt_nameSetsCorrectBuilt_name() throws Exception {
        Built testBuilt = setupBuilt();
        testBuilt.setBuilt_name("Steak House");
        assertNotEquals("Kasuku Centre Lounge",testBuilt.getBuilt_name());
    }

    @Test
    public void setTypeSetsCorrectType() throws Exception {
        Built testBuilt = setupBuilt();
        testBuilt.setType("To Let");
        assertNotEquals("For Sale", testBuilt.getType());
    }

    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        Built testBuilt = setupBuilt();
        testBuilt.setBuilt_description("A Lounge on a 3 Storey Mall in Kile");
        assertNotEquals("Single floor Bar and Lounge", testBuilt.getBuilt_description());
    }
    @Test
    public void setBuilt_priceSetsCorrectBuilt_price() throws Exception {
        Built testBuilt = setupBuilt();
        testBuilt.setBuilt_price(30000000);
        assertNotEquals(20000000, testBuilt.getBuilt_price());
    }

    @Test
    public void setPurposeSetsCorrectPurpose() throws Exception {
        Built testBuilt = setupBuilt();
        testBuilt.setPurpose("Residential");
        assertNotEquals("Commercial", testBuilt.getPurpose());
    }

    @Test
    public void setContactSetsCorrectContact() throws Exception {
        Built testBuilt = setupBuilt();
        testBuilt.setContact("+254733333333");
        assertNotEquals("+254722222222", testBuilt.getContact());
    }

    @Test
    public void setLocationSetsCorrectLocation() throws Exception {
        Built testBuilt = setupBuilt();
        testBuilt.setContact("Lavington");
        assertNotEquals("Kileleshwa", testBuilt.getContact());
    }

    @Test
    public void builtsWithSameConstructorPropertiesAreEqual(){
        Built testBuilt = setupBuilt();
        Built altBuilt = setupAltBuilt();
        assertTrue(testBuilt.equals(altBuilt));
    }

    public Built setupBuilt (){
        return new Built("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222");
    }

    public Built setupAltBuilt (){
        return new Built("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222");
    }


}