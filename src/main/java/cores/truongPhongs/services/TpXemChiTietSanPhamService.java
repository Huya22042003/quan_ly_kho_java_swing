package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpXemChiTietSanPhamCustom;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface TpXemChiTietSanPhamService {
    List<TpXemChiTietSanPhamCustom> listCtsp();
    TpXemChiTietSanPhamCustom addCTSanPham(TpXemChiTietSanPhamCustom custom);
}
