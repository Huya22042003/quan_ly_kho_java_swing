/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

import domainModels.KhachHang;
import domainModels.NhaCungCap;
import domainModels.NhanVien;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuXuatCustom {
    private UUID id;
    private Long ngayTao;
    private String ghiChu;
    private Long ngayThanhToan;
    private TrangThaiPhieuConstant trangThai;
    private UUID nhanVien;
    private UUID khachHang;
   
}
