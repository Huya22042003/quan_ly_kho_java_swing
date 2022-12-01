package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import cores.truongPhongs.repositories.TpXemChiTietSanPhamRepository;
import cores.truongPhongs.services.TpXemChiTietSanPhamService;
import domainModels.ChiTietSanPham;
import domainModels.DonVi;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TpXemChiTietSanPhamImpl implements TpXemChiTietSanPhamService {

    private TpXemChiTietSanPhamRepository repo;

    public TpXemChiTietSanPhamImpl() {
        repo = new TpXemChiTietSanPhamRepository();
    }

    @Override
    public List<TpXemChiTietSanPhamCustom> listCtsp() {
        return repo.getAll();
    }

    @Override
    public TpXemChiTietSanPhamCustom addCTSanPham(TpXemChiTietSanPhamCustom custom) {
        ChiTietSanPham sp = new ChiTietSanPham();
        sp.setGiaBan(custom.getGiaBan());
        sp.setGiaNhap(custom.getGiaNhap());
        sp.setHinhAnh(custom.getHinhAnh());
        sp.setSoLuongTon(custom.getSoLuongTon());
        sp.setMau(custom.getMau());
        sp.setDonVi(custom.getDonVi());
        sp.setTrangThai(custom.getTrangThai());
        sp.setNamBaoHanh(custom.getNamBaoHanh());
        sp.setSanPham(custom.getSanPham());
        custom.setId(repo.addCTSanPham(sp).getId());
        return custom;
    }

    @Override
    public TrangThaiSanPhamConstanst locTt(int a) {
               switch (a) {
            case 0:
                return TrangThaiSanPhamConstanst.CHO_XAC_NHAN;
            case 1:
                return TrangThaiSanPhamConstanst.DA_MO_BAN;
            default:
                return null;
        }

    }

}
