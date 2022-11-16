package domainModels;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "PhieuNhap")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuNhap implements Serializable{
    @Id    
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;
    
    @Column(name = "NgayTao")
    private Long ngayTao;
    
    @Column(name = "GhiChu", columnDefinition = "NVARCHAR(255)")
    private String ghiChu;
    
    @Column(name = "NgayNhan")
    private Long ngayNhan;
    
    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;
    
    @ManyToOne
    @JoinColumn(name = "IdNhaCungCap")
    private NhaCungCap nhaCungCap;
}
