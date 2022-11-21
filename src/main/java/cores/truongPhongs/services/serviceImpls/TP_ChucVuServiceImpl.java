package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TP_ChucVuCustom;
import cores.truongPhongs.repositories.TP_ChucVuRepository;
import cores.truongPhongs.services.TP_ChucVuService;
import domainModels.ChucVu;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

public class TP_ChucVuServiceImpl implements TP_ChucVuService {

    private TP_ChucVuRepository rp = new TP_ChucVuRepository();

    @Override
    public List<TP_ChucVuCustom> getListCV() {
        return rp.getList();
    }

    @Override
    public TP_ChucVuCustom addChucVu(TP_ChucVuCustom custom) {
        ChucVu cv = new ChucVu();
        cv.setMa(custom.getMa());
        cv.setTen(custom.getTen());
        custom.setId(rp.addChucVu(cv).getId());
        return custom;
    }

    @Override
    public boolean updateChucVu(TP_ChucVuCustom custom) {
        ChucVu cv = new ChucVu();
        cv.setMa(custom.getMa());
        cv.setTen(custom.getTen());
        cv.setId(custom.getId());
        return rp.updateChucVu(cv);
    }

    @Override
    public boolean deleteChucVu(UUID id) {
        return rp.deleteChucVu(id);
    }

    @Override
    public TP_ChucVuCustom findChucVuByMa(String ma) {
        return rp.findByMa(ma);
    }

    @Override
    public TP_ChucVuCustom checkValidate(TP_ChucVuCustom cv, JLabel erroMa, JLabel erroTen) {
        boolean check = true;

        if (cv.getMa() != null) {
            if (cv.getMa().trim().length() == 0) {
                erroMa.setText("Mã không được để trống");
                check = false;
//            } else if (!nbh.getMa().matches(ValidateConstant.REGEX_CHU_KHONG_CO_KHOANG_TRANG)) {
//                erroMa.setText("Mã không được có khoảng trắng");
//                check = false;
            } else if (findChucVuByMa(cv.getMa().trim()) != null) {
                erroMa.setText("Mã đã tồn tại");
                check = false;
            } else {
                erroMa.setText("");
            }
        }

        if (cv.getTen().trim().length() == 0) {
            erroTen.setText("Tên không được để trống");
            check = false;
        } else if (cv.getTen().trim().matches("\\d+")) {
            erroTen.setText("Tên phải là kiểu chữ");
            check = false;
        } else {
            erroTen.setText("");
        }

        if (!check) {
            return null;
        }
        return cv;
    }

    @Override
    public List<TP_ChucVuCustom> findAllByRadio(String tk, int rdo) {
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
