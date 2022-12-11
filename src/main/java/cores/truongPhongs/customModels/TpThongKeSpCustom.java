/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.customModels;

import domainModels.ChiTietSanPham;
import domainModels.PhieuXuat;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Acer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TpThongKeSpCustom {

    private PhieuXuat idPhieuXuat;
    private ChiTietSanPham idCtsp;
    private int soLuong;
    
    public BigDecimal doanhThu(){
        return idCtsp.getGiaBan().multiply(new BigDecimal(soLuong));
    }

}
