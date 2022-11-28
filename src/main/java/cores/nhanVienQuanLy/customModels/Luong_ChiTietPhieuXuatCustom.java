/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

import domainModels.ChiTietSanPham;
import domainModels.PhieuXuat;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Luong_ChiTietPhieuXuatCustom {
    private PhieuXuat idPhieuXuat;
    private ChiTietSanPham idChiTietSp;
    private int soLuong;
}
