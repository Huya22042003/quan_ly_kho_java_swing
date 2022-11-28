package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import java.util.List;

/**
 *
 * @author window
 */
public interface NvqlLuongKiemKeCtspService {
    public List<NvqlLuongKiemKeCtspCustom> getAll();
    
    public void updateSoLuong(NvqlLuongKiemKeCtspCustom nvqlLuongKiemKeCtpkService);
}
