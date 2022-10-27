/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import infrastructure.constant.TrangThaiDonHangConstant;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HoaDon")
@IdClass(HoaDonId.class)
public class HoaDon implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDonHang", nullable = false)
    private DonHang idDonHang;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNguoiGiaoHang", nullable = false)
    private NhanVienGiaoHang idNguoiGiaoHang;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "TrangThai")
    private TrangThaiDonHangConstant trangThai;

}
