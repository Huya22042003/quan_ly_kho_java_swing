package domainModels;

import infrastructures.constant.MauConstant;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author QUOC HUY
 */
@Table(name = "ChiTietSanPham")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSanPham implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "GiaNhap")
    private BigDecimal GiaNhap;

    @Column(name = "GiaBan")
    private BigDecimal GiaBan;
    
    @Column(name = "Mau")
    private MauConstant mau;
    
    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdDonVi")
    private DonVi donVi;

    @ManyToOne
    @JoinColumn(name = "IdNamBaoHanh")
    private NamBaoHanh namBaoHanh;

}
