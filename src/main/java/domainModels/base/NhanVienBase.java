/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels.base;

import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.TrangThaiNhanVienConstant;
import java.sql.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author QUOC HUY
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class NhanVienBase {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "MatKhau", columnDefinition = "NVARCHAR(255)")
    private String matKhau;
    
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    
    @Column(name = "HinhAnh")
    private String hinhAnh;
    
    @Column(name = "GioiTinh")
    private GioiTinhConstant gioiTinh;
    
    @Column(name = "TrangThai")
    private TrangThaiNhanVienConstant trangThai;

}
