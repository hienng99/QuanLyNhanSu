package doan;

public class TrinhDoHocVan {
    String maTrinhDoHocVan, tenTrinhDoHocVan, chuyenNganh;
    
    public TrinhDoHocVan() {
        
    }
    
    public TrinhDoHocVan(String maTrinhDoHocVan, String tenTrinhDoHocVan, String chuyenNganh) {
        this.maTrinhDoHocVan = maTrinhDoHocVan;
        this.tenTrinhDoHocVan = tenTrinhDoHocVan;
        this.chuyenNganh = chuyenNganh;
    }
    
    public String getMaTrinhDoHocVan() {
        return this.maTrinhDoHocVan;
    }
    
    public String getTenTrinhDoHocVan() {
        return this.tenTrinhDoHocVan;
    }
    
    public String getChuyenNganh() {
        return this.chuyenNganh;
    }
}
