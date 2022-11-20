/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.NvqlQuanLyPhieuHoanXuatCustom;
import domainModels.KhachHang;
import domainModels.NhanVien;
import domainModels.PhieuXuat;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;

/**
 *
 * @author admin
 */
public interface NvqlQuanLyPhieuHoanXuatService {
    List<NvqlQuanLyPhieuHoanXuatCustom> getList();
    List<NvqlQuanLyPhieuHoanXuatCustom> getListByNgayTao(Long ngayTao, Long ngayKetThuc);
    NvqlQuanLyPhieuHoanXuatCustom addPhieuHoanXuat(NvqlQuanLyPhieuHoanXuatCustom phncs);
    boolean updatePhieuHoanXuat(NvqlQuanLyPhieuHoanXuatCustom phncs);
    boolean deletePhieuHoanXuat(UUID id);
    NvqlQuanLyPhieuHoanXuatCustom findByID(UUID id);
    void loadComBoBoxPx(Combobox cbbPX);
    TrangThaiPhieuConstant loc(int a);
    List<PhieuXuat> getListMaPhieuXuat();
    PhieuXuat chonPX(int chon);
    List<NvqlQuanLyPhieuHoanXuatCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc);
}
