package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TP_KhachHangCustom;
import infrastructures.constant.CoSoConstant;
import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.KhachHangConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;

public interface TP_KhachHangService {

    List<TP_KhachHangCustom> getListKH();

    TP_KhachHangCustom addKH(TP_KhachHangCustom custom);

    boolean updateKH(TP_KhachHangCustom custom);

    boolean deleteKH(UUID id);

    void loadCbbTT(Combobox cbb);
    void loadCbbGT(Combobox cbb);
    void loadCbbDG(Combobox cbb);

    TP_KhachHangCustom checkValidate(TP_KhachHangCustom kh, JLabel erroMa, JLabel erroTen, JLabel erroSDT, JLabel erroEmail,  JLabel erroDiaChi, JLabel erroMatKhau);

    KhachHangConstant loc(int a);
    
    DanhGiaConstant loc1(int b);
    
    GioiTinhConstant loc2(int c);

    TP_KhachHangCustom findKHByMa(String ma);

    List<TP_KhachHangCustom> findAllByRadio(String tk, KhachHangConstant tt, int rdo);
}
