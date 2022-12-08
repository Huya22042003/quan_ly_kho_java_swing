package cores.truongPhongs.customModels;

import domainModels.DonVi;
import domainModels.SanPham;
import infrastructures.constant.MauConstant;
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

    private BigDecimal GiaNhap;

    private BigDecimal GiaBan;
    
    private int namBaoHanh;
    
    private MauConstant mau;

    private SanPham sanPham;

    private DonVi donVi;

<<<<<<< HEAD
    private int namBaoHanh;
    
    private TrangThaiSanPhamConstanst trangThai;
    
    private int size;
    
    private Long ngayTao;
=======
    
>>>>>>> 885dba5c2390c3b3e9d110c93da559ce0624d51a

}
