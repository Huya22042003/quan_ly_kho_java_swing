/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

import domainModels.NhanVien;
import infrastructures.constant.TrangThaiPhieuKiem;
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
public class NvqlLuongKiemKeCustom {
    private UUID id;
    private String maPhieuKiem;
    private Long ngayTao;
    private NhanVien idNV;
    private TrangThaiPhieuKiem trangThai;
}
