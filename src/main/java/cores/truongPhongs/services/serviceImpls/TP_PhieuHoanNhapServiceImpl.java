package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TP_HoanNhap_PhieuNhapCustom;
import cores.truongPhongs.customModels.TP_HoanNhap_ctpCusTom;
import cores.truongPhongs.customModels.TP_HoanNhap_spCustom;
import cores.truongPhongs.customModels.TP_PhieuHoanNhapCustom;
import cores.truongPhongs.repositories.TP_PhieuHoanNhapRepository;
import cores.truongPhongs.services.TP_PhieuHoanNhapService;
import domainModels.PhieuHoanNhap;
import domainModels.PhieuNhap;
import infrastructures.constant.TrangThaiPhieuHoanConstant;
import java.util.List;
import java.util.UUID;
import utilities.DateTimeUtil;

/**
 *
 * @author QUOC HUY
 */
public class TP_PhieuHoanNhapServiceImpl implements TP_PhieuHoanNhapService{
    
    private TP_PhieuHoanNhapRepository rp;

    public TP_PhieuHoanNhapServiceImpl() {
        rp = new TP_PhieuHoanNhapRepository();
    }
    
    @Override
    public List<TP_PhieuHoanNhapCustom> getListPhieuHoanNhap() {
        return rp.getListPhieuHoanNhap();
    }

    @Override
    public List<TP_HoanNhap_PhieuNhapCustom> getListPhieuNhap() {
        return rp.getListPhieuNhap();
    }

    @Override
    public boolean addPhieuNhap(TP_HoanNhap_PhieuNhapCustom pn, String ghiChu, String lyDo) {
        PhieuNhap phieuNhap = new PhieuNhap(pn.getId(), pn.getNgayTao(), pn.getGhiChu(), pn.getNgayThanhToan(), pn.getTrangThai(), pn.getNhanVien(), pn.getNhaCungCap());
        PhieuHoanNhap phn = new PhieuHoanNhap();
        phn.setGhiChu(ghiChu);
        phn.setLiDo(lyDo);
        phn.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());
        phn.setPhieuNhap(phieuNhap);
        phn.setTrangThai(TrangThaiPhieuHoanConstant.CHO_XAC_NHAN);
        
        return rp.addPhieuHoanNhap(phn);
    }

    @Override
    public List<TP_HoanNhap_spCustom> getListSpByPhieuNhap(UUID idPhieuNhap) {
        return rp.getListSpByPhieuNhap(idPhieuNhap);
    }

    @Override
    public boolean addSanPhamInPhieuHoan(UUID sp, UUID idPhieuNhapHoan, int soLuongNhap) {
        return rp.addChiTietPhieuHoanNhap(sp, idPhieuNhapHoan,soLuongNhap);
    }

    @Override
    public List<TP_HoanNhap_ctpCusTom> getListSpByChiTietPhieuHoanNhap(UUID idPhieuHoan) {
        return rp.getListCtpByPhieuHoanNhap(idPhieuHoan);
    }

    @Override
    public boolean removeSanPhamInPhieuHoan(UUID sp, UUID idPhieuNhapHoan, int soLuongNhap) {
       return rp.removeChiTietPhieuHoanNhap(sp, idPhieuNhapHoan,soLuongNhap);
    }

    @Override
    public void updatePhieuHoanNhap(TP_PhieuHoanNhapCustom phnct) {
        PhieuHoanNhap phn = new PhieuHoanNhap();
        phn.setGhiChu(phnct.getGhiChu());
        phn.setId(phnct.getId());
        phn.setLiDo(phnct.getLiDo());
        phn.setNgayTao(phnct.getNgayTao());
        phn.setNgayThanhToan(phnct.getNgayThanhToan());
        phn.setPhieuNhap(phnct.getPhieuNhap());
        phn.setTrangThai(phnct.getTrangThai());
        rp.updatePhieuHoanNhap(phn);
    }
    
}
