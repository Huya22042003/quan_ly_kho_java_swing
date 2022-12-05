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

    public List<Integer> getList();

    public List<Integer> getSoDonHoanNhap();

    public List<Integer> getSoDonHoanXuat();

    public List<Integer> getSoSanPhamDaNhap();
     List<TpThongKeSpCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc);
    public List<Integer> getSoSanPhamDaXuat();
    public List<TpThongKeSpCustom> getListSp();
    public List<Integer> getSoLuongSpHoanNhap();
    public List<Integer> getSoLuongSpHoanXuat();
}
