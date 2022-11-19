/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.KhachHangConstant;
import infrastructures.constant.TrangThaiNhanVienConstant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LayListKhachHangCustom {

    private UUID id;
    private String ma;
    private String ten;
    private String sdt;
    private String email;
    private String matKhau;
    private Long ngaySinh;
    private String hinhAnh;
    private GioiTinhConstant gioiTinh;
    private String diaChi;
    private DanhGiaConstant danhGia;
    private KhachHangConstant trangThai;
}
