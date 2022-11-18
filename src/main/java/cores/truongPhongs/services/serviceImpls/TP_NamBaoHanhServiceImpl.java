package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TP_NamBaoHanhCustom;
import cores.truongPhongs.repositories.TP_NamBaoHanhRepository;
import cores.truongPhongs.services.TP_NamBaoHanhService;
import domainModels.NamBaoHanh;
import infrastructures.constant.ValidateConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

public class TP_NamBaoHanhServiceImpl implements TP_NamBaoHanhService {

    private TP_NamBaoHanhRepository rp = new TP_NamBaoHanhRepository();

    @Override
    public List<TP_NamBaoHanhCustom> getListNBH() {
        return rp.getList();
    }

    @Override
    public TP_NamBaoHanhCustom addNBH(TP_NamBaoHanhCustom custom) {
        NamBaoHanh n = new NamBaoHanh();
        n.setMa(custom.getMa());
        n.setTen(custom.getTen());
        custom.setId(rp.addNBH(n).getId());
        return custom;
    }

    @Override
    public boolean updateNBH(TP_NamBaoHanhCustom custom) {
        NamBaoHanh n = new NamBaoHanh();
        n.setMa(custom.getMa());
        n.setTen(custom.getTen());
        n.setId(custom.getId());
        return rp.updateNBH(n);
    }

    @Override
    public boolean deleteNBH(UUID id) {
        return rp.deleteNBH(id);
    }

    @Override
    public TP_NamBaoHanhCustom findNBHByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public TP_NamBaoHanhCustom checkValidate(TP_NamBaoHanhCustom nbh, JLabel erroMa, JLabel erroTen) {
        boolean check = true;

        if (nbh.getMa() != null) {
            if (nbh.getMa().trim().length() == 0) {
                erroMa.setText("Mã không được để trống");
                check = false;
//            } else if (!nbh.getMa().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
//                erroMa.setText("Mã không được có khoảng trắng");
//                check = false;
            } else if (findNBHByMa(nbh.getMa()) != null) {
                erroMa.setText("Mã đã tồn tại");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (nbh.getTen().trim().length() == 0) {
            erroTen.setText("Tên không được để trống");
            check = false;
        } else {
            erroTen.setText("");
        }

        if (!check) {
            return null;
        }
        return nbh;
    }

    @Override
    public List<TP_NamBaoHanhCustom> findAllByRadio(String tk, int rdo) {
        switch (rdo) {
            case 0:
                return rp.findAllByMa(tk);
            case 1:
                return rp.findAllByTen(tk);
            default:
                return null;
        }
    }

}
