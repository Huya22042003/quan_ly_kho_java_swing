/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import domainModels.Base.NhanVienBase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "TruongPhong")
public class TruongPhong extends NhanVienBase implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhoHang", nullable = false)
    private KhoHang idKhoHang;

}
