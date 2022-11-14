/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

<<<<<<< HEAD
import infrastructures.NhaCungCapConstant;
import infrastructures.constant.CoSoConstant;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
=======
import infrastructures.constant.DanhGiaConstant;
import infrastructures.constant.KhachHangConstant;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
>>>>>>> 4191a03e1bae23f0cbd8ef8df15668152f42b328
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
<<<<<<< HEAD
 * @author window
 */
=======
 * @author QUOC HUY
 */
@Table(name = "NhaCungCap")
>>>>>>> 4191a03e1bae23f0cbd8ef8df15668152f42b328
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
@Table(name = "NhaCungCap")
public class NhaCungCap {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma")
=======
public class NhaCungCap implements Serializable {

    @Id
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "VARCHAR(20)")
>>>>>>> 4191a03e1bae23f0cbd8ef8df15668152f42b328
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(name = "DiaChi", columnDefinition = "NVARCHAR(255)")
    private String diaChi;
<<<<<<< HEAD
    
    @Column(name = "Sdt", columnDefinition = "NVARCHAR(10)")
    private String sdt;
    
    @Column(name = "Email", columnDefinition = "NVARCHAR(50)")
    private String email;
    
    @Column(name = "KhuVuc", columnDefinition = "NVARCHAR(255)")
    private String khuVuc;
    
    @Column(name = "TrangThai")
    private NhaCungCapConstant trangThai;
=======

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
>>>>>>> 4191a03e1bae23f0cbd8ef8df15668152f42b328
}
