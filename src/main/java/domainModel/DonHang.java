/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author QUOC HUY
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DonHang")
public class DonHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "NgayDat")
    private Date ngayDat;

    @Column(name = "HinhThucTT")
    private int hinhThucTT;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "TenNguoiNhan", columnDefinition = "NVARCHAR(255)")
    private String tenNguoiNhan;

    @Column(name = "SdtNguoiNhan")
    private String sdtNguoiNhan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdLoaiHang", nullable = false)
    private LoaiHang idLoaiHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhoHangGui", nullable = false)
    private KhoHang idKhoHangGui;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhoHangNhan", nullable = false)
    private KhoHang idKhoHangNhan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhachHang", nullable = false)
    private KhachHang idKhachHang;
    
    @OneToMany(mappedBy = "idDonHang" , fetch = FetchType.LAZY)
    private List<HoaDon> listDonHang;

}
