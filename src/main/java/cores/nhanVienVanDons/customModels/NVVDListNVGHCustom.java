package cores.nhanVienVanDons.customModels;

import infrastructures.constant.GioiTinhConstant;
import infrastructures.constant.TrangThaiNhanVienConstant;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NVVDListNVGHCustom {

    private UUID id;
    private String ma;
    private String ten;
    private String sdt;
    private String email;
    private String matKhau;
    private Date ngaySinh;
    private String hinhAnh;
    private GioiTinhConstant gioiTinh;
    private TrangThaiNhanVienConstant trangThai;
    private String idKhoHang;
    private String idKhoGiao;

    public NVVDListNVGHCustom(String ma, String ten, String sdt, String email, String matKhau, Date ngaySinh, String hinhAnh, GioiTinhConstant gioiTinh, TrangThaiNhanVienConstant trangThai, String idKhoHang, String idKhoGiao) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.hinhAnh = hinhAnh;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.idKhoHang = idKhoHang;
        this.idKhoGiao = idKhoGiao;
    }
 

}
