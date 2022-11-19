/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;

/**
 *
 * @author admin
 */
public interface NVQLQuanLyPhieuXuatService {
    List<PhieuXuatCustom> getList();
    List<PhieuXuatCustom> getListByNgayTao(Long ngayTao);
    PhieuXuatCustom addPhieuXuat(PhieuXuatCustom pncs);
    boolean updatePhieuXuat(PhieuXuatCustom pncs);
    boolean deletePhieuXuat(UUID id);
    PhieuXuatCustom findByID(UUID id);
    void loadComBox(Combobox cbbTT);  
    TrangThaiPhieuConstant loc(int a);
}
