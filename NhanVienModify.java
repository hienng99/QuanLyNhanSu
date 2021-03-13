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

public class NhanVienModify {
    
    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms?", "root", "");
            
            //query
            String sql = "delete from NhanVien where maNhanVien = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static List<NhanVien> findAll(){
        List<NhanVien> NhanVienList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        Statement statement1 = null;
        Statement statement2 = null;
        Statement statement3 = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql = "CALL LietKeNhanVien()";
            statement = connection.createStatement();
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
            statement3 = connection.createStatement();         
            
            ResultSet resultSet = statement.executeQuery(sql);            
            
            while (resultSet.next()) { 
                          
                NhanVien std = new NhanVien(resultSet.getString("maNhanVien"), 
                        resultSet.getString("hoTenNhanVien"), resultSet.getString("ngaySinh"),
                        resultSet.getString("gioiTinh"), resultSet.getString("danToc"),
                        resultSet.getString("diaChi"), resultSet.getString("soDienThoai"),
                        resultSet.getString("email"), resultSet.getString("maPhongBan"), 
                        resultSet.getString("maChucVu"), resultSet.getString("maTrinhDoHocVan")
                        );
                NhanVienList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return NhanVienList;
    }
    
    public static List<NhanVien> findByMa(String manv){
        List<NhanVien> NhanVienList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql = "select * from NhanVien where maNhanVien like '%" + manv + "%'";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                NhanVien std = new NhanVien(resultSet.getString("maNhanVien"), 
                        resultSet.getString("hoTenNhanVien"), resultSet.getString("ngaySinh"),
                        resultSet.getString("gioiTinh"), resultSet.getString("danToc"),
                        resultSet.getString("diaChi"), resultSet.getString("soDienThoai"),
                        resultSet.getString("email"), resultSet.getString("maPhongBan"),
                        resultSet.getString("maChucVu"), resultSet.getString("maTrinhDoHocVan"));
                NhanVienList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return NhanVienList;
    }
}

