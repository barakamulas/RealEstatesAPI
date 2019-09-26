package models;

import java.util.Objects;

public class Built {
   private int id;
    private String built_name;
    private String built_description;
    private String built_location;
    private int built_price;
    private String type;
    private String purpose;
    private String contact;

    public Built(String built_name, String built_description, String built_location, int built_price, String type, String purpose, String contact) {
        this.built_name = built_name;
        this.built_description = built_description;
        this.built_location = built_location;
        this.built_price = built_price;
        this.type = type;
        this.purpose = purpose;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilt_name() {
        return built_name;
    }

    public void setBuilt_name(String built_name) {
        this.built_name = built_name;
    }

    public String getBuilt_description() {
        return built_description;
    }

    public void setBuilt_description(String built_description) {
        this.built_description = built_description;
    }

    public String getBuilt_location() {
        return built_location;
    }

    public void setBuilt_location(String built_location) {
        this.built_location = built_location;
    }

    public int getBuilt_price() {
        return built_price;
    }

    public void setBuilt_price(int built_price) {
        this.built_price = built_price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Built built = (Built) o;
        return getId() == built.getId() &&
                getBuilt_price() == built.getBuilt_price() &&
                getBuilt_name().equals(built.getBuilt_name()) &&
                getBuilt_description().equals(built.getBuilt_description()) &&
                getBuilt_location().equals(built.getBuilt_location()) &&
                getType().equals(built.getType()) &&
                getPurpose().equals(built.getPurpose()) &&
                getContact().equals(built.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuilt_name(), getBuilt_description(), getBuilt_location(), getBuilt_price(), getType(), getPurpose(), getContact());
    }

}
