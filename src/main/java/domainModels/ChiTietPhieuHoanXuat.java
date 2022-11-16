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
 * @author QUOC HUY
 */
@Entity
@Data
@Table(name = "ChiTietPhieuHoanXuat")
@IdClass(ChiTietPhieuHoanXuatId.class)
public class ChiTietPhieuHoanXuat implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdPhieuHoanXuat", nullable = false)
    private PhieuHoanXuat idPhieuHoanXuat;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", nullable = false)
    private ChiTietSanPham idChiTietSp;

    @Column(name = "SoLuong")
    private int soLuong;

}