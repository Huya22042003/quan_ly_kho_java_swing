/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpThongKeSpCustom;
import cores.truongPhongs.customModels.TpTongSoSanPhamTrongKhoCustom;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface TpThongKeService {

    public List<TpTongSoSanPhamTrongKhoCustom> getList();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanNhap();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoDonHoanXuat();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaNhap();

    List<TpThongKeSpCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc);

    public List<TpTongSoSanPhamTrongKhoCustom> getSoSanPhamDaXuat();

    public List<TpThongKeSpCustom> getListSp();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoLuongSpHoanNhap();

    public List<TpTongSoSanPhamTrongKhoCustom> getSoLuongSpHoanXuat();

    List<TpThongKeSpCustom> phanTrang(List<TpThongKeSpCustom> list, int offset, int limit);
}
