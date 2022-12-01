package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.repositories.TpQuanLySanPhamRepository;
import cores.truongPhongs.services.TpQuanLySanPhamService;
import domainModels.SanPham;
import infrastructures.constant.ValidateConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author MMC
 */
public class TpQuanLySanPhamServiceImpl implements TpQuanLySanPhamService {

    private TpQuanLySanPhamRepository rp = new TpQuanLySanPhamRepository();

    @Override
    public List<TpQuanLySanPhamCustom> getAll() {
        return rp.getAll();
    }

    @Override
    public TpQuanLySanPhamCustom addSanPham(TpQuanLySanPhamCustom custom) {
        SanPham sp = new SanPham();
        sp.setMa(custom.getMa());
        sp.setTen(custom.getTen());
        custom.setId(rp.addSanPham(sp).getId());
        return custom;
    }

    @Override
    public boolean updateSanPham(TpQuanLySanPhamCustom custom) {
        SanPham sp = new SanPham();
        sp.setMa(custom.getMa());
        sp.setTen(custom.getTen());
        sp.setId(custom.getId());
        return rp.updateSanPham(sp);
    }

    @Override
    public boolean deleteSanPham(UUID id) {
        return rp.deleteSanPham(id);
    }

    @Override
    public TpQuanLySanPhamCustom findSanPhamByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public List<TpQuanLySanPhamCustom> findAllByRadio(String ten, int rdo) {
        switch (rdo) {
            case 0:
                return rp.findAllByMa(ten);
            case 1:
                return rp.findAllByTen(ten);
            default:
                return null;
        }
    } //

    @Override
    public TpQuanLySanPhamCustom checkValidate(TpQuanLySanPhamCustom sp, JLabel erroMa, JLabel erroTen) {

        boolean check = true;

        if (sp.getMa() != null) {
            if (sp.getMa().trim().length() == 0) {
                erroMa.setText("Mã không được để trống");
                check = false;
            } else if (!sp.getMa().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
                erroMa.setText("Mã không được có khoảng trắng");
                check = false;
            } else if (findSanPhamByMa(sp.getMa()) != null) {
                erroMa.setText("Mã đã tồn tại");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (sp.getTen().trim().length() == 0) {
            erroTen.setText("Tên không được để trống");
            check = false;
        } else if (sp.getTen().matches("\\d+")) {
            erroTen.setText("Tên phải là chữ");
            check = false;
        } else {
            erroTen.setText("");
        }

        if (!check) {
            return null;
        }

        return sp;
    }

    @Override
    public SanPham findID(UUID id) {
        return rp.findID(id);
    }

    @Override
    public List<SanPham> getABC(Long ngayThanhToan) {
        return rp.getABC(ngayThanhToan);
    }

}
