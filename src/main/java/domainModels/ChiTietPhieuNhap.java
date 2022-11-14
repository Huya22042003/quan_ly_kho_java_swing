/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author window
 */
@Entity
@Data
@Table(name = "ChiTietPhieuNhap")
@IdClass(ChiTietPhieuNhapId.class)
public class ChiTietPhieuNhap implements Serializable{
    
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdPhieuNhap")
    private PhieuNhap idPhieuNhap;
    
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham idChiTietSP;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
}