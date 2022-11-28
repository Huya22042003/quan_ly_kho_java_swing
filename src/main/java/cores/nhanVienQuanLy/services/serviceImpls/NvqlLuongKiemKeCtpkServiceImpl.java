/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtpkCustom;
import cores.nhanVienQuanLy.repositories.NvqlLuongKiemKeCtpkRepository;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtpkService;
import domainModels.ChiTietPhieuKiemKe;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeCtpkServiceImpl implements NvqlLuongKiemKeCtpkService{

    private NvqlLuongKiemKeCtpkRepository rp;
    
    public NvqlLuongKiemKeCtpkServiceImpl(){
        rp = new NvqlLuongKiemKeCtpkRepository();
    }

    @Override
    public List<NvqlLuongKiemKeCtpkCustom> getAll(UUID id) {
        return rp.getAll(id);
    }

    @Override
    public void addCTPK(NvqlLuongKiemKeCtpkCustom b) {
        ChiTietPhieuKiemKe a = new ChiTietPhieuKiemKe(b.getIdPhieuKiem(), b.getIdChiTietSanPham(), b.getSoLuongTon(), b.getSoLuongThucTon());
        rp.addCTPK(a);
    }
    
    
}
