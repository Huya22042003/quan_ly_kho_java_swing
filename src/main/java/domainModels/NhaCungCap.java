/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import infrastructures.NhaCungCapConstant;
import infrastructures.constant.CoSoConstant;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author window
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NhaCungCap")
public class NhaCungCap {
    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(name = "DiaChi", columnDefinition = "NVARCHAR(255)")
    private String diaChi;
    
    @Column(name = "Sdt", columnDefinition = "NVARCHAR(10)")
    private String sdt;
    
    @Column(name = "Email", columnDefinition = "NVARCHAR(50)")
    private String email;
    
    @Column(name = "KhuVuc", columnDefinition = "NVARCHAR(255)")
    private String khuVuc;
    
    @Column(name = "TrangThai")
    private NhaCungCapConstant trangThai;
}
