package cores.exportPDF.services;

import domainModels.ChiTietSanPham;
import java.util.UUID;

/**
 *
 * @author QUOC HUY
 */
public interface ExportSanPhamService {
    boolean exportSanPham(String fileName, UUID idSanPham);
    ChiTietSanPham findChiTietSanPhamById(UUID idSanPham);
}
