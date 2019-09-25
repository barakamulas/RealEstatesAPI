package models;

public class Selling {
    private String land_name;
    private String land_description;
    private String land_type;
    private int land_price;
    private String purpose;
    private String contact;
    private String land_location;
    private int size;
    private int id ;

    public Selling(String land_name,String land_description,String land_type,int land_price,String purpose,String contact,String land_location, int size){
        this.land_name = land_name;
        this.land_description = land_description;
        this.land_type = land_type;
        this.land_price = land_price;
        this.purpose = purpose;
        this.contact = contact;
        this.land_location = land_location;
        this.size = size;

    }

    public String getLand_name() {
        return land_name;
    }

    public String getLand_description() {
        return land_description;
    }

    public String getLand_type() {
        return land_type;
    }

    public int getLand_price() {
        return land_price;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getContact() {
        return contact;
    }

    public String getLand_location() {
        return land_location;
    }

    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }
}
