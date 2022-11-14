/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import java.util.Objects;

/**
 *
 * @author window
 */
public class ChiTietPhieuHoanNhapId {
    private PhieuHoanNhap idPhieuHoanNhap;

    private ChiTietSanPham idChiTietSp;
    
    private int soLuong;
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idPhieuHoanNhap);
        hash = 71 * hash + Objects.hashCode(this.idChiTietSp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChiTietPhieuHoanNhapId other = (ChiTietPhieuHoanNhapId) obj;
        if (!Objects.equals(this.idPhieuHoanNhap, other.idPhieuHoanNhap)) {
            return false;
        }
        return Objects.equals(this.idChiTietSp, other.idChiTietSp);
    }
    
}
