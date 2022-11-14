/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.KhachHangConstant;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "NhaCungCap")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCap implements Serializable {

    @Id
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "VARCHAR(20)")
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(name = "DiaChi", columnDefinition = "NVARCHAR(255)")
    private String diaChi;

    @Column(name = "Email", columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "Sdt", columnDefinition = "VARCHAR(10)")
    private String sdt;

    @Column(name = "DanhGia", columnDefinition = "INT")
    private DanhGiaConstant danhGia;

    @Column(name = "TrangThai", columnDefinition = "INT")
    private KhachHangConstant trangThai;

    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien idNhanVien;
}
