package domainModels;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "NamBaoHanh")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NamBaoHanh implements Serializable{
    
    @Id
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "VARCHAR(20)")
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;
//    
//    @OneToMany(mappedBy = "namBaoHanh")
//    List<ChiTietSanPham> chiTietSanPhams;
}
