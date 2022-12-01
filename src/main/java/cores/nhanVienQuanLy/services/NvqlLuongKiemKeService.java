package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import java.util.List;

/**
 *
 * @author window
 */
public interface NvqlLuongKiemKeService {
    public List<NvqlLuongKiemKeCustom> getAll();
    void Insert(NvqlLuongKiemKeCustom phieuKiemKe);
    boolean UpdateTrangThai(NvqlLuongKiemKeCustom phieuKiemKe);
}
