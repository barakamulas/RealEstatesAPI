package models;

import java.util.Objects;

public class Selling {
    private String land_name;
    private String land_description;
    private String selling_type;
    private int land_price;
    private String purpose;
    private String contact;
    private String land_location;
    private int size;
    private int id ;

    public Selling(String land_name,String land_description,String selling_type,int land_price,String purpose,String contact,String land_location, int size){
        this.land_name = land_name;
        this.land_description = land_description;
        this.selling_type = selling_type;
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

    public String getSelling_type() {
        return selling_type;
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

    public void setLand_name(String land_name) {
        this.land_name = land_name;
    }

    public void setLand_description(String land_description) {
        this.land_description = land_description;
    }

    public void setSelling_type(String land_type) {
        this.selling_type = land_type;
    }

    public void setLand_price(int land_price) {
        this.land_price = land_price;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setLand_location(String land_location) {
        this.land_location = land_location;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Selling selling = (Selling) o;
        return land_price == selling.land_price &&
                size == selling.size &&
                id == selling.id &&
                Objects.equals(land_name, selling.land_name) &&
                Objects.equals(land_description, selling.land_description) &&
                Objects.equals(selling_type, selling.selling_type) &&
                Objects.equals(purpose, selling.purpose) &&
                Objects.equals(contact, selling.contact) &&
                Objects.equals(land_location, selling.land_location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(land_name, land_description, selling_type, land_price, purpose, contact, land_location, size, id);
    }
}
