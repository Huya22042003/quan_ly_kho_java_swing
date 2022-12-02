package cores.exportPDF.services;

import domainModels.ChiTietPhieuXuat;
import domainModels.ChiTietSanPham;
import domainModels.PhieuXuat;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author QUOC HUY
 */
public interface ExportSanPhamService {
    boolean exportSanPham(String fileName, UUID idSanPham);
    ChiTietSanPham findChiTietSanPhamById(UUID idSanPham);
    boolean exportPhieuXuat(String fileName, UUID idPhieu);
    PhieuXuat findPhieuXuatById(UUID id);
    List<ChiTietPhieuXuat> findChiTietPhieuXuat(UUID id);
}
