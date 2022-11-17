package domainModels;

import infrastructures.constant.CoSoConstant;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author QUOC HUY
 */
@Entity
@Getter
@Setter
@Table(name = "CoSo")
public class CoSo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten", columnDefinition = "NVARCHAR(255)")
    private String ten;

    @Column(name = "ViTri", columnDefinition = "NVARCHAR(255)")
    private String viTri;

    @Column(name = "TrangThai")
    private CoSoConstant trangThai;

}
