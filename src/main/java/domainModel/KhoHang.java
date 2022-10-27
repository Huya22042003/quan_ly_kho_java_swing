/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import infrastructure.constant.KhoHangConstant;
import java.io.Serializable;
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
@Table(name = "KhoHang")
public class KhoHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "NVARCHAR(255)")
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(name = "TrangThai")
    private KhoHangConstant trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCoSo", nullable = false)
    private CoSo idCoSo;

    @OneToMany(mappedBy = "idKhoHang" , fetch = FetchType.LAZY)
    private List<NhanVienGiaoHang> listKhoHangNhanVienGiaoHang;
    
    @OneToMany(mappedBy = "idKhoGiao" , fetch = FetchType.LAZY)
    private List<NhanVienGiaoHang> listKhoGiaoNhanVienGiaoHang;
    
    @OneToMany(mappedBy = "idKhoHang" , fetch = FetchType.LAZY)
    private List<NhanVienVanDon> listNhanVienVanDon;
    
    @OneToMany(mappedBy = "idKhoHang" , fetch = FetchType.LAZY)
    private List<TruongPhong> listTruongPhong;
    
    @OneToMany(mappedBy = "idKhoHangGui" , fetch = FetchType.LAZY)
    private List<DonHang> listKhoGui;
    
    @OneToMany(mappedBy = "idKhoHangNhan" , fetch = FetchType.LAZY)
    private List<DonHang> listKhoNhan;
    
    

}
