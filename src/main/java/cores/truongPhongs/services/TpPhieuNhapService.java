package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpPhieuNhapCustom;
import infrastructures.constant.TrangThaiPhieuConstant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author Acer
 */
public interface TpPhieuNhapService {
    
    List<TpPhieuNhapCustom> getListPn();
    TpPhieuNhapCustom addPn(TpPhieuNhapCustom p);
    boolean updatePn(TpPhieuNhapCustom p);
    boolean deletePn(UUID id);
    TpPhieuNhapCustom checkValidate(String ghiChu,Date ngayThanhToan,JLabel errNgayThanhToan,JLabel errGhiChu);
    TpPhieuNhapCustom findPhieuNhapById(UUID id);
    TrangThaiPhieuConstant loc(int a);
    List<TpPhieuNhapCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc);
    List<TpPhieuNhapCustom> getListByNgayTao(Long ngayTao, Long ngayKetThuc);
   
}

    