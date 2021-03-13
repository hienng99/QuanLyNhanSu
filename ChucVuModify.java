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

public class ChucVuModify {
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?", "root", "");
            
            //query
            String sql = "delete from ChucVu where maChucVu = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Không thể xóa!");
            //Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<ChucVu> findAll(){
        List<ChucVu> ChucVuList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try{
            //lay tat ca danh sach chuc vu
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //query
            String sql = "CALL LietKeChucVu()";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                ChucVu std = new ChucVu(resultSet.getString("maChucVu"), 
                        resultSet.getString("tenChucVu"), resultSet.getFloat("heSoLuong"));
                ChucVuList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ChucVuList;
    }
    
    public static List<ChucVu> findByMa(String maChucVu){
        List<ChucVu> ChucVuList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql = "select * from ChucVu where maChucVu like '%" + maChucVu + "%'";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                ChucVu std = new ChucVu(resultSet.getString("maChucVu"), 
                        resultSet.getString("tenChucVu"), resultSet.getFloat("heSoLuong")
                        );
                ChucVuList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ChucVuModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ChucVuList;
    }
}
