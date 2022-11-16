/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.customModels;

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
public class NvqlQuanLyPhieuNhapCustom {
    private UUID id;
    private String ghiChu;
    private Long ngayNhan;
    private Long ngayTao;
    private UUID idNhanVien;
    private String tenNhanVien;
    private UUID idNcc;
    private String tenNcc;
    
}
