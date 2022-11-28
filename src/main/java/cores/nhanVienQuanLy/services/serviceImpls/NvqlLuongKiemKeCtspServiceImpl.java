/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import cores.nhanVienQuanLy.repositories.NvqlLuongKiemKeCtspRepository;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtpkService;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtspService;
import domainModels.ChiTietSanPham;
import infrastructures.constant.MauConstant;
import infrastructures.constant.TrangThaiSanPhamConstanst;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeCtspServiceImpl implements NvqlLuongKiemKeCtspService{
    private NvqlLuongKiemKeCtspRepository rp;
    
    public NvqlLuongKiemKeCtspServiceImpl(){
        rp = new NvqlLuongKiemKeCtspRepository();
    }

    @Override
    public List<NvqlLuongKiemKeCtspCustom> getAll() {
        return rp.getAll();
    }

    @Override
    public void updateSoLuong(NvqlLuongKiemKeCtspCustom a) {
        ChiTietSanPham ctsp = new ChiTietSanPham(a.getId(), 
                a.getSoLuongTon(), 
                a.getHinhAnh(), 
                a.getGiaNhap(), 
                a.getGiaBan(), 
                a.getNamBaoHanh(), 
                a.getMau(), 
                a.getTrangThai(), 
                a.getSanPham(), 
                a.getDonVi());
        rp.updateSoLuong(ctsp);
    }
}
