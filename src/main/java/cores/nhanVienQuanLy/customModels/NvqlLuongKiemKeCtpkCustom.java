/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

import domainModels.ChiTietSanPham;
import domainModels.PhieuKiemKe;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author window
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NvqlLuongKiemKeCtpkCustom {
    private String ma;
    private String ten;
    private int soLuongTon;
    private int soLuongThucTon;
    private PhieuKiemKe idPhieuKiem;
    private ChiTietSanPham idChiTietSanPham;
    
    public int getChenhLech() {
        return soLuongThucTon - soLuongTon;
    }
}
