package models.dao;

import models.Built;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oBuiltDao implements BuiltDao {
    private final Sql2o sql2o;
    public Sql2oBuiltDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Built built) {
        String sql = "INSERT INTO builts (built_name, built_description, built_location, built_price, type, purpose, contact) VALUES (:built_name, :built_description, :built_location, :built_price, :type, :purpose, :contact)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(built)
                    .executeUpdate()
                    .getKey();
            built.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Built> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM builts")
                    .executeAndFetch(Built.class);
        }
    }



    @Override
    public Built findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM builts WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Built.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from builts WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from builts";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void update(int id, String built_name, String built_description, String built_location, int built_price, String type, String purpose, String contact) {
        String sql = "UPDATE builts SET built_name = :built_name,  built_description= :built_description, built_location = :built_location, built_price = :built_price, type = :type, purpose = :purpose, contact = :contact WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("built_name",built_name)
                    .addParameter("built_description", built_description)
                    .addParameter("built_location", built_location)
                    .addParameter("built_price", built_price)
                    .addParameter("type", type)
                    .addParameter("purpose", purpose)
                    .addParameter("contact", contact)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }



}