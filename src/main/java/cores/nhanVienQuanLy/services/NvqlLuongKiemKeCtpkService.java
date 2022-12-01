package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtpkCustom;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author window
 */
public interface NvqlLuongKiemKeCtpkService {
    public List<NvqlLuongKiemKeCtpkCustom> getAll(UUID id);
    
    public void addCTPK(NvqlLuongKiemKeCtpkCustom nvqlLuongKiemKeCtpkCustom);
}
