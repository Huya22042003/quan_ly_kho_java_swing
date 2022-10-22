package domainModels;

import domainModels.Base.NhanVienBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "NhanVienGiaoHang")
public class NhanVienGiaoHang extends NhanVienBase implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhoHang", nullable = false)
    private KhoHang idKhoHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhoGiao", nullable = false)
    private KhoHang idKhoGiao;
    
    @OneToMany(mappedBy = "idNguoiGiaoHang" , fetch = FetchType.LAZY)
    private List<HoaDon> listHoaDon;
    
}
