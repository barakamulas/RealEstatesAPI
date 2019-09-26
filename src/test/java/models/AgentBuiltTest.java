package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgentBuiltTest {


    @Test
    public void getAgentBuilt_nameReturnsCorrectAgentBuilt_name() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals("Kasuku Centre Lounge", testAgentBuilt.getBuilt_name());
    }

    @Test
    public void getTypeReturnsCorrectType() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals("For Sale", testAgentBuilt.getType());
    }

    @Test
    public void getAgentBuiltDescriptionReturnsCorrectDescription() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals("Single floor Bar and Lounge", testAgentBuilt.getBuilt_description());
    }
    @Test
    public void getAgentBuilt_priceReturnsCorrectAgentBuilt_price() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals(20000000, testAgentBuilt.getBuilt_price());
    }

    @Test
    public void getPurposeReturnsCorrectPurpose() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals("Commercial", testAgentBuilt.getPurpose());
    }

    @Test
    public void getContactReturnsCorrectContact() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals("+254722222222", testAgentBuilt.getContact());
    }


    @Test
    public void getLocationReturnsCorrectLocation() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        assertEquals("Kileleshwa", testAgentBuilt.getBuilt_location());
    }


//    ................................................................Setters


    @Test
    public void setAgentBuilt_nameSetsCorrectAgentBuilt_name() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        testAgentBuilt.setBuilt_name("Steak House");
        assertNotEquals("Kasuku Centre Lounge",testAgentBuilt.getBuilt_name());
    }

    @Test
    public void setTypeSetsCorrectType() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        testAgentBuilt.setType("To Let");
        assertNotEquals("For Sale", testAgentBuilt.getType());
    }

    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        testAgentBuilt.setBuilt_description("A Lounge on a 3 Storey Mall in Kile");
        assertNotEquals("Single floor Bar and Lounge", testAgentBuilt.getBuilt_description());
    }
    @Test
    public void setAgentBuilt_priceSetsCorrectAgentBuilt_price() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        testAgentBuilt.setBuilt_price(30000000);
        assertNotEquals(20000000, testAgentBuilt.getBuilt_price());
    }

    @Test
    public void setPurposeSetsCorrectPurpose() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        testAgentBuilt.setPurpose("Residential");
        assertNotEquals("Commercial", testAgentBuilt.getPurpose());
    }

    @Test
    public void setContactSetsCorrectContact() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        testAgentBuilt.setContact("+254733333333");
        assertNotEquals("+254722222222", testAgentBuilt.getContact());
    }

    @Test
    public void setLocationSetsCorrectLocation() throws Exception {
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        testAgentBuilt.setContact("Lavington");
        assertNotEquals("Kileleshwa", testAgentBuilt.getContact());
    }

    @Test
    public void agentBuiltsWithSameConstructorPropertiesAreEqual(){
        AgentBuilt testAgentBuilt = setupAgentBuilt();
        AgentBuilt altAgentBuilt = setupAltAgentBuilt();
        AgentBuilt thirdAgent = setupThirdAgentBuilt();
        assertTrue(testAgentBuilt.equals(altAgentBuilt));
        assertFalse(testAgentBuilt.equals(thirdAgent));
    }

    public AgentBuilt setupAgentBuilt (){
        return new AgentBuilt("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222",1);
    }

    public AgentBuilt setupAltAgentBuilt (){
        return new AgentBuilt("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222222",1);
    }

    public AgentBuilt setupThirdAgentBuilt (){
        return new AgentBuilt("Kasuku Centre Lounge", "Single floor Bar and Lounge", "Kileleshwa", 20000000, "For Sale", "Commercial","+254722222221",1);
    }


}