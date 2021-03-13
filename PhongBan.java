package doan;

public class PhongBan {
    String maPhongBan, tenPhongBan, diaChi, soDienThoai;
    long phuCap;
    
    //Ham khoi tao mac dinh
    public PhongBan(){
        
    }
    
    //Ham khoi tao co tham so
    public PhongBan(String maPhongBan, String tenPhongBan, String diaChi, String soDienThoai, long phuCap){       
        this.maPhongBan = maPhongBan;
        this.tenPhongBan =  tenPhongBan;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.phuCap = phuCap;
    }   
    
    public String getMaPhongBan() {
        return maPhongBan;
    }
    
    public String getTenPhongBan() {
        return tenPhongBan;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public String getSoDienThoai() {
        return soDienThoai;
    }
    
    public long getPhuCap() {
        return phuCap;
    }
}
