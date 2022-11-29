package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import domainModels.SanPham;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author MMC
 */
public interface TpQuanLySanPhamService {

    public List<TpQuanLySanPhamCustom> getAll();

    TpQuanLySanPhamCustom addSanPham(TpQuanLySanPhamCustom custom);

    boolean updateSanPham(TpQuanLySanPhamCustom custom);

    boolean deleteSanPham(UUID id);

    TpQuanLySanPhamCustom findSanPhamByMa(String ma);

    List<TpQuanLySanPhamCustom> findAllByRadio(String ten, int rdo);

    TpQuanLySanPhamCustom checkValidate(TpQuanLySanPhamCustom sp, JLabel erroMa, JLabel erroTen);

    public SanPham findID(UUID id);

    public List<SanPham> getABC(Long ngayThanhToan);

}
