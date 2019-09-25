package models.dao;
import models.Selling;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSellingDao implements SellingDao{

    private final Sql2o sql2o;
    public Sql2oSellingDao(Sql2o sql2o){this.sql2o =sql2o;}

    //implementation for add method
    @Override
    public void add(Selling selling) {
        String sql = "INSERT INTO selling (land_name,land_description,selling_type,land_price, purpose, contact,land_location, size) VALUES" +
                " (:land_name,:land_description,:selling_type,:land_price, :purpose, :contact,:land_location, :size);";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(selling)
                    .executeUpdate()
                    .getKey();
            selling.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    //implementation for all method
    @Override
    public List<Selling> all(){
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM selling")
            .executeAndFetch(Selling.class);
        }
    }
    //implementation for findById method
    @Override
    public Selling findById(int id){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM selling WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Selling.class);
        }
    }
    //implementation for update method
    @Override
    public void update(int id,String Nland_name,String Nland_description,String Nselling_type,int Nland_price,String Npurpose,String Ncontact,String Nland_location, int Nsize) {
        String sql = "UPDATE selling SET (land_name,land_description,selling_type,land_price, purpose, contact,land_location, size) = " +
                "(:land_name,:land_description,:selling_type,:land_price, :purpose, :contact,:land_location, :size) WHERE id = :id;";

        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("land_name",Nland_name)
                    .addParameter("land_description",Nland_description)
                    .addParameter("selling_type",Nselling_type)
                    .addParameter("land_price",Nland_price)
                    .addParameter("purpose",Npurpose)
                    .addParameter("contact",Ncontact)
                    .addParameter("land_location",Nland_location)
                    .addParameter("size",Nsize)
                    .executeUpdate();

        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    //implementation for deleteById
    @Override
    public void deleteById(int id){
        String sql = "DELETE from selling WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    //implementation for clearAll()
    @Override
    public void clearAll(){
        String sql = "DELETE FROM selling";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
