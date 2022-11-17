/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpQuanLyChiTietSanPhamCustom;
import cores.truongPhongs.repositories.TpQuanLyChiTietSanPhamRepository;
import cores.truongPhongs.services.TpQuanLyChiTietSanPhamService;
import java.util.List;

/**
 *
 * @author MMC
 */
public class TpQuanLyChiTietSanPhamServiceImpl implements TpQuanLyChiTietSanPhamService{

    private TpQuanLyChiTietSanPhamRepository rp = new TpQuanLyChiTietSanPhamRepository();
    @Override
    public List<TpQuanLyChiTietSanPhamCustom> getAll() {
        return rp.getAll();
    }
    
}
