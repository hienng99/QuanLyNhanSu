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

public class PhongBanModify {
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?", "root", "");
            
            //query
            String sql = "delete from PhongBan where maPhongBan = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("Không thể xóa!");
            //Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<PhongBan> findAll(){
        List<PhongBan> PhongBanList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql = "CALL LietKePhongBan()";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                PhongBan std = new PhongBan(resultSet.getString("maPhongBan"), 
                        resultSet.getString("tenPhongBan"), resultSet.getString("diaChi"),
                        resultSet.getString("soDienThoai"), resultSet.getLong("phuCap"));
                PhongBanList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return PhongBanList;
    }
    
    public static List<PhongBan> findByMa(String maPhongBan){
        List<PhongBan> PhongBanList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql = "select * from PhongBan where maPhongBan like '%" + maPhongBan + "%'";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                PhongBan std = new PhongBan(resultSet.getString("maPhongBan"), 
                        resultSet.getString("tenPhongBan"), resultSet.getString("diaChi"),
                        resultSet.getString("soDienThoai"), resultSet.getLong("phuCap"));
                PhongBanList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongBanModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return PhongBanList;
    }
}

