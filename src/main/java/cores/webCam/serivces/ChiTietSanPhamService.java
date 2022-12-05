/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.webCam.serivces;

import cores.webCam.customModels.ChiTietSanPhamCustom;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author QUOC HUY
 */
public interface ChiTietSanPhamService {
    ConcurrentHashMap<UUID, ChiTietSanPhamCustom> getMapChiTietSanPham();
    boolean addChiTietPhieuXuat(UUID idPhieuXuat, UUID idChiTietSanPham, int soLuong);
}
