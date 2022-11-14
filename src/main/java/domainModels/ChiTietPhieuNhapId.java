/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author QUOC HUY
 */
@Getter
@Setter
public class ChiTietPhieuNhapId implements Serializable{
    
    private PhieuNhap idPhieuNhap;

    private ChiTietSanPham idChiTietSp;
    
    private int soLuong;
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idPhieuNhap);
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
        final ChiTietPhieuNhapId other = (ChiTietPhieuNhapId) obj;
        if (!Objects.equals(this.idPhieuNhap, other.idPhieuNhap)) {
            return false;
        }
        return Objects.equals(this.idChiTietSp, other.idChiTietSp);
    }
    
}
