package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.customModels.TpThemSanPhamCustom;
import domainModels.SanPham;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author MMC
 */
public interface TpQuanLySanPhamService {

    public List<TpQuanLySanPhamCustom> getAll(String ten);

    TpQuanLySanPhamCustom addSanPham(TpQuanLySanPhamCustom custom);

    boolean updateSanPham(TpThemSanPhamCustom custom);

    boolean deleteSanPham(UUID id);

    TpQuanLySanPhamCustom findSanPhamByMa(String ma);

    TpQuanLySanPhamCustom checkValidate(TpQuanLySanPhamCustom sp, JLabel erroMa, JLabel erroTen);

    List<TpQuanLySanPhamCustom> phanTrang(List<TpQuanLySanPhamCustom> list, int offset, int limit);

}
