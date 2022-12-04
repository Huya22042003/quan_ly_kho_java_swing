/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpTongSoSanPhamTrongKhoCustom;
import cores.truongPhongs.repositories.TpThongKeRepository;
import cores.truongPhongs.services.TpTongSoSanPhamTrongKhoService;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TpTongSoSanPhamTrongKhoServiceImpl implements TpTongSoSanPhamTrongKhoService{
    TpThongKeRepository repo ;

    public TpTongSoSanPhamTrongKhoServiceImpl() {
        repo = new TpThongKeRepository();
    }
    
    @Override
    public List<TpTongSoSanPhamTrongKhoCustom> getList() {
        return repo.getSoLuongSpTon();
    }

    @Override
    public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanNhap() {
        return repo.getSoDonHoanNhap();
    }

    @Override
    public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaNhap() {
        return repo.getSoSanPhamDaNhap();
    }

    

    @Override
    public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanXuat() {
        return repo.getSoDonHoanXuat();
    }

    @Override
    public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaXuat() {
        return repo.getSoSanPhamDaXuat();
    }
    
}
