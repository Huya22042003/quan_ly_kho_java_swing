/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(name = "Email")
    private String email;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau", columnDefinition = "NVARCHAR(255)")
    private String matKhau;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "GioiTinh")
    private int gioiTinh;

    @Column(name = "DiaChi", columnDefinition = "NVARCHAR(255)")
    private String diaChi;
    
    @OneToMany(mappedBy = "idKhachHang" , fetch = FetchType.LAZY)
    private List<DonHang> listKhachHang;
}
