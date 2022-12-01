package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TP_KhachHangCustom;
import cores.truongPhongs.services.TP_KhachHangService;
import domainModels.KhachHang;
import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.KhachHangConstant;
import infrastructures.constant.ValidateConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.Converter;
import utilities.palette.Combobox;

import cores.truongPhongs.repositories.TP_KhachHangRepository;

public class TP_KhachHangServiceImpl implements TP_KhachHangService {

    private TP_KhachHangRepository rp = new TP_KhachHangRepository();

    @Override
    public List<TP_KhachHangCustom> getListKH() {
        return rp.getList();
    }

    @Override
    public TP_KhachHangCustom addKH(TP_KhachHangCustom custom) {
        KhachHang kh = new KhachHang();
        kh.setMa(custom.getMa());
        kh.setTen(custom.getTen());
        kh.setSdt(custom.getSdt());
        kh.setEmail(custom.getEmail());
        kh.setDiaChi(custom.getDiaChi());
        kh.setDanhGia(custom.getDanhGia());
        kh.setMatKhau(custom.getMatKhau());
        kh.setHinhAnh(custom.getHinhAnh());
        kh.setNgaySinh(custom.getNgaySinh());
        kh.setGioiTinh(custom.getGioiTinh());
        kh.setTrangThai(custom.getTrangThai());
        custom.setId(rp.addKH(kh).getId());
        return custom;
    }

    @Override
    public boolean updateKH(TP_KhachHangCustom custom) {
        KhachHang kh = new KhachHang();
        kh.setMa(custom.getMa());
        kh.setTen(custom.getTen());
        kh.setSdt(custom.getSdt());
        kh.setEmail(custom.getEmail());
        kh.setDiaChi(custom.getDiaChi());
        kh.setNgaySinh(custom.getNgaySinh());
        kh.setDanhGia(custom.getDanhGia());
        kh.setMatKhau(custom.getMatKhau());
        kh.setHinhAnh(custom.getHinhAnh());
        kh.setGioiTinh(custom.getGioiTinh());
        kh.setTrangThai(custom.getTrangThai());
        kh.setId(custom.getId());
        return rp.updateKH(kh);
    }

    @Override
    public boolean deleteKH(UUID id) {
        return rp.deleteKH(id);
    }

    @Override
    public void loadCbbTT(Combobox cbb) {
        cbb.removeAll();
        cbb.addItem(Converter.trangThaiKhachHang(KhachHangConstant.DANG_LAM_VIEC));
        cbb.addItem(Converter.trangThaiKhachHang(KhachHangConstant.SAP_BO));
        cbb.addItem(Converter.trangThaiKhachHang(KhachHangConstant.DA_NGUNG_CUNG_CAP));

    }

    @Override
    public TP_KhachHangCustom findKHByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public List<TP_KhachHangCustom> findAllByRadio(String tk, KhachHangConstant tt, int rdo) {
        switch (rdo) {
            case 0:
                return rp.findAllByTen(tk, tt);
            case 1:
                return rp.findAllBySDT(tk, tt);
            case 2:
                return rp.findAllByDiaChi(tk, tt);
            default:
                return null;
        }
    }

    @Override
    public TP_KhachHangCustom checkValidate(TP_KhachHangCustom kh, JLabel erroMa, JLabel erroTen, JLabel erroSDT, JLabel erroEmail, JLabel erroDiaChi, JLabel erroMatKhau, JLabel erroNgaySinh) {
        boolean check = true;

        if (kh.getMa() != null) {
            if (kh.getMa().trim().length() == 0) {
                erroMa.setText("Mã không được để trống");
                check = false;

            } else if (!kh.getMa().trim().matches(kh.getMa().toUpperCase())) {
                erroMa.setText("Mã phải viết hoa");
                check = false;
            } else if (findKHByMa(kh.getMa().trim()) != null) {
                erroMa.setText("Mã đã tồn tại");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (kh.getTen().trim().length() == 0) {
            erroTen.setText("Tên không được để trống");
            check = false;
        } else if (!kh.getTen().trim().matches("[A-Z a-z]+")) {
            erroTen.setText("Tên phải là kiểu chữ");
            check = false;
        } else {
            erroTen.setText("");
        }

        if (kh.getSdt().trim().length() == 0) {
            erroSDT.setText("Số điện thoại không được để trống");
            check = false;
        } else if (!kh.getSdt().trim().matches(ValidateConstant.REGEX_PHONE_NUMBER)) {
            erroSDT.setText("SĐT sai định dạng");
            check = false;
        } else {
            erroSDT.setText("");
        }

        if (kh.getEmail().trim().length() == 0) {
            erroEmail.setText("Email không được để trống");
            check = false;
        } else if (!kh.getEmail().trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            erroEmail.setText("Email sai định dạng");
            check = false;
        } else {
            erroEmail.setText("");
        }

        if (kh.getDiaChi().trim().length() == 0) {
            erroDiaChi.setText("Địa chỉ không được để trống");
            check = false;
        } else if (!kh.getDiaChi().trim().matches("^[A-Z a-z 0-9]+$")) {
            erroDiaChi.setText("Địa chỉ sai định dạng");
            check = false;
        } else {
            erroDiaChi.setText("");
        }
        if (kh.getMatKhau().trim().length() == 0) {
            erroMatKhau.setText("Mật khẩu không được để trống");
            check = false;
        } else if (!kh.getMatKhau().trim().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")) {
            erroMatKhau.setText("Mật khẩu sai định dạng");
            check = false;

        } else {
            erroMatKhau.setText("");
        }

        if (kh.getNgaySinh() == null) {
            erroNgaySinh.setText("Bạn phải chọn ngày sinh");
            check = false;
        } else {
            erroNgaySinh.setText("");
        }

        if (!check) {
            return null;
        }

        return kh;

    }

    @Override
    public KhachHangConstant loc(int a) {
        switch (a) {
            case 0:
                return KhachHangConstant.DANG_LAM_VIEC;
            case 1:
                return KhachHangConstant.SAP_BO;
            case 2:
                return KhachHangConstant.DA_NGUNG_CUNG_CAP;
            default:
                return null;
        }
    }

    @Override
    public DanhGiaConstant loc1(int b) {
        switch (b) {
            case 0:
                return DanhGiaConstant.TOT;
            case 1:
                return DanhGiaConstant.BAT_ON;
            case 2:
                return DanhGiaConstant.TAM_ON;
            case 3:
                return DanhGiaConstant.XAU;
            default:
                return null;
        }
    }

    @Override
    public GioiTinhConstant loc2(int c) {
        switch (c) {
            case 0:
                return GioiTinhConstant.NU;
            case 1:
                return GioiTinhConstant.KHAC;
            case 2:
                return GioiTinhConstant.NAM;
            default:
                return null;
        }
    }

    @Override
    public void loadCbbGT(Combobox cbb) {
        cbb.addItem(Converter.trangThaiGioiTinh(GioiTinhConstant.NU));
        cbb.addItem(Converter.trangThaiGioiTinh(GioiTinhConstant.KHAC));
        cbb.addItem(Converter.trangThaiGioiTinh(GioiTinhConstant.NAM));
    }

    @Override
    public void loadCbbDG(Combobox cbb) {
        cbb.addItem(Converter.trangThaiDanhGia(DanhGiaConstant.TOT));
        cbb.addItem(Converter.trangThaiDanhGia(DanhGiaConstant.BAT_ON));
        cbb.addItem(Converter.trangThaiDanhGia(DanhGiaConstant.TAM_ON));
        cbb.addItem(Converter.trangThaiDanhGia(DanhGiaConstant.XAU));
    }
}
