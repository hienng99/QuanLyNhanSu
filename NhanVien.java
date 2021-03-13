package doan;

public class NhanVien {
    String maNhanVien, hoTenNhanVien, ngaySinh, gioiTinh;
    String danToc, diaChi, soDienThoai, email, maPhongBan;
    String maChucVu, maTrinhDoHocVan;
    String tenPhongBan, tenChucVu, tenTrinhDoHocVan;
    
    public NhanVien(){
        
    }
    
    public NhanVien(String maNhanVien, String hoTenNhanVien, String ngaySinh, String gioiTinh, String danToc, String diaChi, String soDienThoai, String email, String tenPhongBan, String tenChucVu, String tenTrinhDoHocVan){
        this.maNhanVien = maNhanVien;
        this.hoTenNhanVien = hoTenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh  =gioiTinh;
        this.danToc = danToc;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.tenPhongBan = tenPhongBan;
        this.tenChucVu = tenChucVu;
        this.tenTrinhDoHocVan = tenTrinhDoHocVan;
    }
    
    public String getMaNhanVien() {
        return this.maNhanVien;
    }
    
    public String getHoTenNhanVien() {
        return this.hoTenNhanVien;
    }
    
    public String getNgaySinh() {
        return this.ngaySinh;
    }
    
    public String getGioiTinh() {
        return this.gioiTinh;
    }
    
    public String getDanToc() {
        return this.danToc;
    }
    
    public String getDiaChi() {
        return this.diaChi;
    }
    
    public String getSoDienThoai() {
        return this.soDienThoai;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getMaPhongBan() {
        return this.maPhongBan;
    }
    
    public String getMaChucVu() {
        return this.maChucVu;
    }
    
    public String getMaTrinhDoHocVan() {
        return this.maTrinhDoHocVan;
    }
    
    public String getTenPhongBan() {
        return this.tenPhongBan;
    }
    
    public String getTenChucVu() {
        return this.tenChucVu;
    }
    
    public String getTenTrinhDoHocVan() {
        return this.tenTrinhDoHocVan;
    }
}
