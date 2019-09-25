package models.dao;
import models.Selling;

import java.util.List;

public interface SellingDao {
    //Create a new land
    void add(Selling selling);

    //READ (List all lands)
    List<Selling> all();

    //READ by id(Get land by id)
    Selling findById(int id);

    //UPDATE(add new land )
    void update (int id, String land_name,String land_description,String selling_type,int land_price,String purpose,String contact,String land_location, int size);

    //DELETE (delete an individual land entry)
    void deleteById(int id);

    //DELETE ALL (delete all land entries entered)
    void clearAll();
}
