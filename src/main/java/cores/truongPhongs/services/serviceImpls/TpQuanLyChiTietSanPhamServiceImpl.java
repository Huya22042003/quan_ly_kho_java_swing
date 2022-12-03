package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLyDonViCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import cores.truongPhongs.repositories.TpQuanLyChiTietSanPhamRepository;
import cores.truongPhongs.services.TpQuanLyChiTietSanPhamService;
import domainModels.ChiTietSanPham;
import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.Converter;
import utilities.DateTimeUtil;
import utilities.palette.Combobox;

/**
 *
 * @author MMC
 */
public class TpQuanLyChiTietSanPhamServiceImpl implements TpQuanLyChiTietSanPhamService {

    private TpQuanLyChiTietSanPhamRepository rp = new TpQuanLyChiTietSanPhamRepository();

    @Override
    public List<TpQuanLyChiTietSanPhamCustom> getAll() {
        return rp.getAll();
    }

    @Override
    public TpQuanLyChiTietSanPhamCustom addCTSanPham(TpQuanLyChiTietSanPhamCustom custom) {
        ChiTietSanPham sp = new ChiTietSanPham();
        sp.setGiaBan(custom.getGiaBan());
        sp.setGiaNhap(custom.getGiaNhap());
        sp.setHinhAnh(custom.getHinhAnh());
        sp.setSoLuongTon(custom.getSoLuongTon());
        sp.setMau(custom.getMau());
        sp.setDonVi(custom.getDonVi());
        sp.setNamBaoHanh(custom.getNamBaoHanh());
        sp.setSanPham(custom.getSanPham());
        sp.setNgayTao(DateTimeUtil.convertDateToTimeStampSecond());

        custom.setId(rp.addCTSanPham(sp).getId());
        return custom;
    }

    @Override
    public boolean updateCTSanPham(TpQuanLyChiTietSanPhamCustom custom) {
        ChiTietSanPham sp = new ChiTietSanPham();
        sp.setGiaBan(custom.getGiaBan());
        sp.setGiaNhap(custom.getGiaNhap());
        sp.setHinhAnh(custom.getHinhAnh());
        sp.setSoLuongTon(custom.getSoLuongTon());
        sp.setMau(custom.getMau());
        sp.setDonVi(custom.getDonVi());
        sp.setNamBaoHanh(custom.getNamBaoHanh());
        sp.setSanPham(custom.getSanPham());
        sp.setNgayTao(custom.getNgayTao());
        sp.setId(custom.getId());

        return rp.updateCTSanPham(sp);
    }

    @Override
    public boolean deleteCTSanPham(UUID id) {
        return rp.deleteCTSanPham(id);
    }

    @Override
    public TpQuanLyChiTietSanPhamCustom findCTSanPhamById(UUID id) {
        return rp.findById(id);
    }

    @Override
    public List<TpQuanLyChiTietSanPhamCustom> findAllByRadio(int rdo, MauConstant tt, String tk) {
        switch (rdo) {
            case 0:
                return rp.findAllByGiaNhap(tk, tt);
            case 1:
                return rp.findAllByGiaBan(tk, tt);
            case 2:
                return rp.findAllByTenSanPham(tk);
            default:
                return null;
        }
    }

    @Override
    public TpQuanLyChiTietSanPhamCustom checkValidate(UUID donVi, String namBH, UUID sanPham, String hinhAnh, String giaNhap, String giaBan, String soLuong, String size,
             JLabel erroHinhAnh, JLabel erroGiaNhap, JLabel erroGiaBan, JLabel erroSoLuong, JLabel erroSize, JLabel erroNamBH, MauConstant mau) {
        boolean check = true;
        if (giaNhap.trim().length() == 0) {
            erroGiaNhap.setText("Giá nhập không được để trống");
            check = false;
        } else if (!giaNhap.matches("^[0-9]+$")) {
            erroGiaNhap.setText("Giá nhập sai định dạng");
            check = false;
        } else {
            erroGiaNhap.setText("");
        }

        if (giaBan.trim().length() == 0) {
            erroGiaBan.setText("Giá bán không được để trống");
            check = false;
        } else if (!giaBan.matches("^[0-9]+$")) {
            erroGiaBan.setText("Giá bán sai định dạng");
            check = false;
        } else {
            erroGiaBan.setText("");
        }
        if (soLuong.trim().length() == 0) {
            erroSoLuong.setText("Số lượng tồn không được để trống");
            check = false;
        } else if (!soLuong.matches("\\d+")) {
            erroSoLuong.setText("Số lượng tồn không được là chữ");
            check = false;
        } else {
            erroSoLuong.setText("");
        }

        if (namBH.trim().length() == 0) {
            erroNamBH.setText("Năm bảo hành không được để trống");
            check = false;
        } else if (!namBH.matches("\\d+")) {
            erroNamBH.setText("Năm bảo hành không được là chữ");
            check = false;
        } else {
            erroNamBH.setText("");
        }
        if (size.trim().length() == 0) {
            erroSize.setText("Size không được để trống");
            check = false;
        } else if (!size.matches("^[0-9]+$")) {
            erroSize.setText("Size sai định dạng");
            check = false;
        } else {
            erroSize.setText("");
        }

        if (!check) {
            return null;
        }
        TpQuanLyChiTietSanPhamCustom sp = new TpQuanLyChiTietSanPhamCustom();
        sp.setGiaBan(new BigDecimal(Double.parseDouble(giaBan)));
        sp.setGiaNhap(new BigDecimal(Double.parseDouble(giaNhap)));
        sp.setSoLuongTon(Integer.parseInt(soLuong));
        sp.setHinhAnh(hinhAnh);
        sp.setMau(mau);
        sp.setNamBaoHanh(Integer.parseInt(namBH));
        sp.setDonVi(rp.findIDDonVi(donVi));
        sp.setSanPham(rp.findIDSanPham(sanPham));
        sp.setSize(Integer.parseInt(size));
        return sp;
    }

    @Override
    public TpQuanLyChiTietSanPhamCustom findCTSanPhamGia(BigDecimal gia) {
        return rp.findByGia(gia);
    }

    @Override
    public List<TpQuanLyDonViCustom> getAllDonVi() {
        return rp.getAllDonVi();
    }

    @Override
    public DonVi findIDDonVi(UUID id) {
        return rp.findIDDonVi(id);
    }

    @Override
    public List<TpQuanLySanPhamCustom> getAllSanPham() {
        return rp.getAllSanPham();
    }

    @Override
    public SanPham findIDSanPham(UUID id) {
        return rp.findIDSanPham(id);
    }

    @Override
    public MauConstant loc(int a) {
        switch (a) {
            case 0:
                return MauConstant.VANG;
            case 1:
                return MauConstant.XANH_LA;
            case 2:
                return MauConstant.DO;
            case 3:
                return MauConstant.XANH_DUONG;
            case 4:
                return MauConstant.HONG;
            case 5:
                return MauConstant.CAM;
            case 6:
                return MauConstant.DEN;
            case 7:
                return MauConstant.TRANG;
            default:
                return null;
        }
    }

    @Override
    public void loadCombobox(Combobox cbb) {
        cbb.removeAll();
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.VANG));
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.XANH_LA));
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.DO));
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.XANH_DUONG));
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.HONG));
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.CAM));
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.DEN));
        cbb.addItem(Converter.trangThaiMauSac(MauConstant.TRANG));

    }

    @Override
    public List<TpQuanLyDonViCustom> getAllDonVi1() {
        return rp.getAllDonVi1();
    }

    @Override
    public List<TpQuanLySanPhamCustom> getAllSanPham1() {
        return rp.getAllSanPham1();
    }

    @Override
    public TpXemChiTietSanPhamCustom checkValidate1(UUID donVi, String namBH, UUID sanPham, String hinhAnh, String giaNhap,
            String soLuong, String size, MauConstant mau, Long ngayTao, String trangThai, JLabel erroSoLuongNhap,
            JLabel erroGiaNhap, JLabel erroSize, JLabel erroNamBH) {

        boolean check = true;
        if (soLuong.trim().length() == 0) {
            erroSoLuongNhap.setText("Số lượng nhập không được để trống");
            check = false;
        } else if (!soLuong.matches("^[0-9]+$")) {
            erroSoLuongNhap.setText("Số lượng nhập sai định dạng");
            check = false;
        } else {
            erroSoLuongNhap.setText("");
        }

        if (giaNhap.trim().length() == 0) {
            erroGiaNhap.setText("Giá nhập không được để trống");
            check = false;
        } else if (!giaNhap.matches("^[0-9]+$")) {
            erroGiaNhap.setText("Giá nhập sai định dạng");
            check = false;
        } else {
            erroGiaNhap.setText("");
        }
        if (size.trim().length() == 0) {
            erroSize.setText("Size không được để trống");
            check = false;
        } else if (!size.matches("^[0-9]+$")) {
            erroSize.setText("Size sai định dạng");
            check = false;
        } else {
            erroSize.setText("");
        }

        if (namBH.trim().length() == 0) {
            erroNamBH.setText("Năm bảo hành không được để trống");
            check = false;
        } else if (!namBH.matches("\\d+")) {
            erroNamBH.setText("Năm bảo hành không được là chữ");
            check = false;
        } else {
            erroNamBH.setText("");
        }

        if (!check) {
            return null;
        }

        TpXemChiTietSanPhamCustom sp = new TpXemChiTietSanPhamCustom();
        sp.setGiaNhap(new BigDecimal(Double.parseDouble(giaNhap)));
        sp.setSoLuongTon(Integer.parseInt(soLuong));
        sp.setHinhAnh(hinhAnh);
        sp.setMau(mau);
        sp.setNamBaoHanh(Integer.parseInt(namBH));
        sp.setDonVi(rp.findIDDonVi(donVi));
        sp.setSanPham(rp.findIDSanPham(sanPham));
        sp.setSize(Integer.parseInt(size));
        sp.setNgayTao(new Date().getTime());
        sp.setTrangThai(TrangThaiSanPhamConstanst.CHO_XAC_NHAN);
        return sp;
    }

    @Override
    public List<TpQuanLyChiTietSanPhamCustom> phanTrang(List<TpQuanLyChiTietSanPhamCustom> list, int offset, int limit) {
        List<TpQuanLyChiTietSanPhamCustom> listPhanTrang = new ArrayList<>();
        int sum = limit + offset;
        if (list.size() <= sum) {
            sum = list.size();
        }
        for (int i = offset; i < sum; i++) {
            if (list.get(i) == null) {
                break;
            }
            TpQuanLyChiTietSanPhamCustom el = list.get(i);
            listPhanTrang.add(el);
        }
        return listPhanTrang;
    }

}
