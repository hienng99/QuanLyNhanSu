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

public class LuongModify {
    public static List<Luong> findAll(){
        List<Luong> LuongList = new ArrayList<>();
        Connection connection = null;
        Statement statement1 = null;
        Statement statement2 = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql1 = "SELECT maNhanVien, hoTenNhanVien, heSoLuong from NhanVien nv inner join ChucVu cv where nv.maChucVu = cv.maChucVu";
            String sql2 = "SELECT phuCap from NhanVien nv inner join PhongBan pb where nv.maPhongBan = pb.maPhongBan";
            statement1 = connection.createStatement(); 
            statement2 = connection.createStatement();
            
            ResultSet resultSet1 = statement1.executeQuery(sql1);
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            
            while (resultSet1.next() && resultSet2.next()) { 
                double luong = resultSet1.getDouble("heSoLuong") * 1600000 + resultSet2.getLong("phuCap");          
                Luong std = new Luong(resultSet1.getString("maNhanVien"), 
                        resultSet1.getString("hoTenNhanVien"), luong);
                LuongList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(LuongModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement1 != null || statement1 != null) {
                try {
                    statement1.close();
                    statement2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LuongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LuongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return LuongList;
    }
    
    public static List<Luong> findByMa(String maNhanVien){
        List<Luong> LuongList = new ArrayList<>();
        Connection connection = null;
        Statement statement1 = null;
        Statement statement2 = null;
        
        try{           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
            //Thuc hien cau truy van
            String sql1 = "call TimKiemHSLByMa('" + maNhanVien + "')";
            String sql2 = "call TimKiemPhuCapByMa('" + maNhanVien + "')";
            statement1 = connection.createStatement(); 
            statement2 = connection.createStatement();
            
            ResultSet resultSet1 = statement1.executeQuery(sql1);
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            
            while (resultSet1.next() && resultSet2.next()) { 
                double luong = resultSet1.getDouble("heSoLuong") * 1600000 + resultSet2.getLong("phuCap");          
                Luong std = new Luong(resultSet1.getString("maNhanVien"), 
                        resultSet1.getString("hoTenNhanVien"), luong);
                LuongList.add(std);
            }
        }catch(SQLException ex){
            Logger.getLogger(LuongModify.class.getName()).log(Level.SEVERE, null,ex);
        }finally{
            if(statement1 != null || statement1 != null) {
                try {
                    statement1.close();
                    statement2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LuongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LuongModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return LuongList;
    }
}

