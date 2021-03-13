package doan;

public class ChucVu {
    String maChucVu, tenChucVu;
    float heSoLuong;
    
    public ChucVu(){
    }
    
    public ChucVu(String maChucVu, String tenChucVu, float heSoLuong){
    this.maChucVu = maChucVu;
    this.tenChucVu = tenChucVu;
    this.heSoLuong =  heSoLuong;
    }
    
    public String getmaChucVu() {
        return maChucVu;
    }

    public void setmaChucVu(String MaChucVu) {
        this.maChucVu = maChucVu;
    }

    public String gettenChucVu() {
        return tenChucVu;
    }

    public void settenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public float getheSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(String gender) {
        this.heSoLuong = heSoLuong;
    }
}

