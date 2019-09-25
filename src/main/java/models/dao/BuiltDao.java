package models.dao;

import models.Built;

import java.util.List;

public interface BuiltDao {


    void add(Built built);

    List<Built> getAll();

    void deleteById(int id);

    void clearAll();


    //update
    //omit for now

    //delete

}
