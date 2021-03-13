package doan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrinhDoHocVanModify {
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?", "root", "");
            
            //query
            String sql = "delete from TrinhDoHocVan where maTrinhDoHocVan = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Không thể xóa!");
            //Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }   
    
    public static List<TrinhDoHocVan> findAll(){
        List<TrinhDoHocVan> TrinhDoHocVanList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql = "CALL LietKeTrinhDoHocVan()";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                TrinhDoHocVan std = new TrinhDoHocVan(resultSet.getString("maTrinhDoHocVan"), 
                        resultSet.getString("tenTrinhDoHocVan"), resultSet.getString("chuyenNganh"));
                TrinhDoHocVanList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return TrinhDoHocVanList;
    }
    
    public static List<TrinhDoHocVan> findByTen(String tenTrinhDoHocVan){
        List<TrinhDoHocVan> TrinhDoHocVanList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql = "select * from TrinhDoHocVan where tenTrinhDoHocVan like '%" + tenTrinhDoHocVan + "%'";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                TrinhDoHocVan std = new TrinhDoHocVan(resultSet.getString("maTrinhDoHocVan"), 
                        resultSet.getString("tenTrinhDoHocVan"), resultSet.getString("chuyennganh"));
                TrinhDoHocVanList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TrinhDoHocVanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return TrinhDoHocVanList;
    }
}

