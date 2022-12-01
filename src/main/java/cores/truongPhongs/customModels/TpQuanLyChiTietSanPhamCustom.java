package cores.truongPhongs.customModels;

import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author MMC
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TpQuanLyChiTietSanPhamCustom {

    private UUID id;

    private int soLuongTon;

    private String hinhAnh;

    private BigDecimal giaNhap;

    private BigDecimal giaBan;
    
    private MauConstant mau;

    private SanPham sanPham;

    private DonVi donVi;

    private int namBaoHanh;
    
    private TrangThaiSanPhamConstanst trangThai;
    
    private int size;
    
    private Long ngayTao;

}
