/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuNhapCustom;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author Acer
 */
public interface NvqlQuanLyPhieuNhapService {
    List<NvqlQuanLyPhieuNhapCustom> getListPn();
    NvqlQuanLyPhieuNhapCustom addPn(NvqlQuanLyPhieuNhapCustom p);
    boolean updatePn(NvqlQuanLyPhieuNhapCustom p);
    boolean deletePn(UUID id);
    NvqlQuanLyPhieuNhapCustom checkValidate(String ghiChu,Date ngayNhap,Date ngayTao,JLabel errNgayNhap, JLabel errNgayTao,JLabel errGhiChu);
    NvqlQuanLyPhieuNhapCustom findPhieuNhapById(UUID id);
    
}
