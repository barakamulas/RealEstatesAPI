package models;

public class Selling {
    private String land_name;
    private String land_description;
    private String land_type;
    private double land_price;
    private String purpose;
    private String contact;
    private String land_location;
    private double size;
    private int id ;

    public Selling(String land_name,String land_description,String land_type,float land_price,String purpose,String contact,String land_location, float size){
        this.land_name = land_name;
        this.land_description = land_description;
        this.land_type = land_type;
        this.land_price = land_price;
        this.purpose = purpose;
        this.contact = contact;
        this.land_location = land_location;
        this.size = size;

    }



}
