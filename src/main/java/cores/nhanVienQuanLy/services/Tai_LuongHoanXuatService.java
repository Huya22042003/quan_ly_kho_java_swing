package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.ChiTietPhieuHoanXuatCustom;
import cores.nhanVienQuanLy.customModels.PhieuHoanXuatCustom;
import cores.nhanVienQuanLy.customModels.PhieuXuatCustom;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author admin
 */
public interface Tai_LuongHoanXuatService {
    List<PhieuHoanXuatCustom> getListPHX();
    ConcurrentHashMap<UUID, String> getMapPhx();
    void updatePHX(PhieuHoanXuatCustom phxct);
    List<ChiTietPhieuHoanXuatCustom> getListCTphxByID(UUID id);
    void updateCtPHX(ChiTietPhieuHoanXuatCustom ctphxct);
    void addPhieuHoanXuatTuDong(PhieuXuatCustom pxct, String ghiChu, String liDo);
    void addChiTietPhieuHoanXuat(ChiTietPhieuHoanXuatCustom ctphxct);
//    PhieuHoanXuat getPhxByIdPhieuXuat(UUID id);
}
