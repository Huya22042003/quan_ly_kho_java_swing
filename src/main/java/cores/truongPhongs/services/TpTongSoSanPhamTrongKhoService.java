/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpTongSoSanPhamTrongKhoCustom;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface TpTongSoSanPhamTrongKhoService {

    public List<TpTongSoSanPhamTrongKhoCustom> getList();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanNhap();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanXuat();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaNhap();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaXuat();
}
