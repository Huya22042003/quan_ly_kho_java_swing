/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.customModels;

import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.TrangThaiNhanVienConstant;
import java.util.Date;
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
public class TpQuanLyNvghCustom {

    private UUID id;
    private String ma;
    private String ten;
    private String sdt;
    private String email;
    private String matKhau;
    private Date ngaySinh;
    private String hinhAnh;
    private GioiTinhConstant gioiTinh;
    private String diaChi;
    private TrangThaiNhanVienConstant trangThai;

}
