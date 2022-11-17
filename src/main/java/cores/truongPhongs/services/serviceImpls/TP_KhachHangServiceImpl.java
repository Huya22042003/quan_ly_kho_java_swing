package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TP_KhachHangCustom;
import cores.truongPhongs.repositories.TP_KhachHangRepository;
import cores.truongPhongs.services.TP_KhachHangService;
import infrastructures.constant.CoSoConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;
import views.main.KhachHang;

public class TP_KhachHangServiceImpl implements TP_KhachHangService {

    private TP_KhachHangRepository rp = new TP_KhachHangRepository();

    @Override
    public List<TP_KhachHangCustom> getListKH() {
        return rp.getList();
    }

    @Override
    public TP_KhachHangCustom addKH(TP_KhachHangCustom custom) {
        KhachHang kh = new KhachHang();
        kh.setM
        kh.setTen(custom.getTen());
        kh.setViTri(custom.getViTri());
        kh.setTrangThai(custom.getTrangThai());
        custom.setId(rp.addKH(kh).getId());
        return custom;
    }

    @Override
    public boolean updateKH(TP_KhachHangCustom custom) {
        KhachHang kh = new KhachHang();
        kh.setMa(custom.getMa());
        kh.setTen(custom.getTen());
        kh.setViTri(custom.getViTri());
        kh.setTrangThai(custom.getTrangThai());
        kh.setId(custom.getId());
        return rp.updateKH(kh);
    }

    @Override
    public boolean deleteKH(UUID id) {

    }

    @Override
    public void loadCombobox(Combobox cbb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CoSoConstant loc(int a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TP_KhachHangCustom findKHByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TP_KhachHangCustom> findAllByRadio(String ten, CoSoConstant tt, int rdo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TP_KhachHangCustom checkValidate(TP_KhachHangCustom kh, JLabel erroMa, JLabel erroTen, JLabel erroSDT, JLabel erroEmail, JLabel erroMatKhau, JLabel erroDiaChi, JLabel erroDanhGia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
