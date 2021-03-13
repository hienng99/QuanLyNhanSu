package doan;

public class Luong {
    String maNhanVien, tenNhanVien;
    double tienLuong;
    
    public Luong() {
        
    }
    
    public Luong(String maNhanVien, String tenNhanVien, double tienLuong) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tienLuong = tienLuong;
    }
    
    public String getMaNhanVien() {
        return this.maNhanVien;
    } 
    
    public String getTenNhanVien() {
        return this.tenNhanVien;
    } 
    
    public double getTienLuong() {
        return this.tienLuong;
    }
}
