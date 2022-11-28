/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.customModels;

import infrastructures.constant.TrangThaiPhieuConstant;
import infrastructures.constant.TrangThaiPhieuNhapConstant;
import java.util.UUID;
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
public class TpPhieuNhapCustom {
    private UUID id;
    private String ghiChu;
    private Long ngayThanhToan;
    private Long ngayTao;
    private TrangThaiPhieuConstant trangThai;
    private UUID idNhanVien;
    private String tenNhanVien;
    private UUID idNcc;
    private String tenNcc;

}