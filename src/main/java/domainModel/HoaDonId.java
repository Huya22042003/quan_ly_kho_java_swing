/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.io.Serializable;
import java.util.Objects;
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
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonId implements Serializable {
    
    private DonHang idDonHang;
    private NhanVienGiaoHang idNguoiGiaoHang;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idDonHang);
        hash = 53 * hash + Objects.hashCode(this.idNguoiGiaoHang);
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
        final HoaDonId other = (HoaDonId) obj;
        if (!Objects.equals(this.idDonHang, other.idDonHang)) {
            return false;
        }
        return Objects.equals(this.idNguoiGiaoHang, other.idNguoiGiaoHang);
    }
    
    
}
