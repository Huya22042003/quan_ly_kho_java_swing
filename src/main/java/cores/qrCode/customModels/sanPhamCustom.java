package cores.qrCode.customModels;

import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author QUOC HUY
 */
public class sanPhamCustom {
    
    private UUID id;

    private int soLuongTon;

    private String hinhAnh;

    private BigDecimal GiaNhap;

    private BigDecimal GiaBan;

    private int namBaoHanh;

    private MauConstant mau;
    
    private TrangThaiSanPhamConstanst trangThai;

    private SanPham sanPham;

    private DonVi donVi;
}
