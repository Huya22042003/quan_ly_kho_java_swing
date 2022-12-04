package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.NhaCungCapCustom;
import cores.truongPhongs.repositories.TpQuanlyNhaCungCapRepository;
import cores.truongPhongs.services.TpQuanlyNhaCungCapService;
import domainModels.NhaCungCap;
import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.KhachHangConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilities.palette.Combobox;

/**
 *
 * @author admin
 */
public class TpQuanlyNhaCungCapServiceImpl implements TpQuanlyNhaCungCapService {

    private TpQuanlyNhaCungCapRepository rp;

    public TpQuanlyNhaCungCapServiceImpl() {
        rp = new TpQuanlyNhaCungCapRepository();
    }

    @Override
    public List<NhaCungCapCustom> getListByMa(String ma) {
        return rp.getListByMa(ma);
    }

    @Override
    public NhaCungCapCustom addNhaCungCap(NhaCungCapCustom nccct) {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMa(nccct.getMa());
        ncc.setTen(nccct.getTen());
        ncc.setDiaChi(nccct.getDiaChi());
        ncc.setEmail(nccct.getEmail());
        ncc.setSdt(nccct.getSdt());
        ncc.setDanhGia(nccct.getDanhGia());
        ncc.setTrangThai(nccct.getTrangThai());
        nccct.setId(rp.addNhaCungCap(ncc).getId());
        return nccct;
    }

    @Override
    public boolean updateNhaCungCap(NhaCungCapCustom nccct) {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setMa(nccct.getMa());
        ncc.setTen(nccct.getTen());
        ncc.setDiaChi(nccct.getDiaChi());
        ncc.setEmail(nccct.getEmail());
        ncc.setSdt(nccct.getSdt());
        ncc.setDanhGia(nccct.getDanhGia());
        ncc.setTrangThai(nccct.getTrangThai());
        ncc.setId(nccct.getId());
        return rp.updateNhaCungCap(ncc);
    }

    @Override
    public boolean deleteNhaCungCap(UUID id) {
        return rp.deleteNhaCungCap(id);
    }

    @Override
    public void loadComboxDanhGia(Combobox cbbDanhGia) {
        cbbDanhGia.removeAll();
        cbbDanhGia.addItem(DanhGiaConstant.BAT_ON);
        cbbDanhGia.addItem(DanhGiaConstant.TAM_ON);
        cbbDanhGia.addItem(DanhGiaConstant.TOT);
        cbbDanhGia.addItem(DanhGiaConstant.XAU);
    }

    @Override
    public void loadComboxTrangThai(Combobox cbbTrangThai) {
        cbbTrangThai.removeAll();
        cbbTrangThai.addItem(KhachHangConstant.DANG_LAM_VIEC);
        cbbTrangThai.addItem(KhachHangConstant.DA_NGUNG_CUNG_CAP);
        cbbTrangThai.addItem(KhachHangConstant.SAP_BO);

    }

    @Override
    public DanhGiaConstant locDG(int a) {
        switch (a) {
            case 0:
                return DanhGiaConstant.BAT_ON;
            case 1:
                return DanhGiaConstant.TAM_ON;
            case 2:
                return DanhGiaConstant.TOT;
            case 3:
                return DanhGiaConstant.XAU;
            default:
                return null;
        }
    }

    @Override
    public KhachHangConstant locKH(int a) {
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
    public NhaCungCapCustom findNCCByMa(String ma) {
        return rp.findByNCC(ma);
    }

    @Override
    public List<NhaCungCapCustom> getList() {
        return rp.getList();
    }

    @Override
    public List<NhaCungCapCustom> phanTrang(List<NhaCungCapCustom> list, int offset, int limit) {
        List<NhaCungCapCustom> listPhanTrang = new ArrayList<>();
        int sum = limit + offset;
        if (list.size() <= sum) {
            sum = list.size();
        }
        for (int i = offset; i < sum; i++) {
            if (list.get(i) == null) {
                break;
            }
            NhaCungCapCustom el = list.get(i);
            listPhanTrang.add(el);
        }
        return listPhanTrang;
    }

}
