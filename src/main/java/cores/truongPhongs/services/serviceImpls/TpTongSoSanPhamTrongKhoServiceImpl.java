/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpThongKeSpCustom;
import cores.truongPhongs.customModels.TpTongSoSanPhamTrongKhoCustom;
import cores.truongPhongs.repositories.TpThongKeRepository;
import java.util.List;
import cores.truongPhongs.services.TpThongKeService;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class TpTongSoSanPhamTrongKhoServiceImpl implements TpThongKeService {

    TpThongKeRepository repo;

    public TpTongSoSanPhamTrongKhoServiceImpl() {
        repo = new TpThongKeRepository();
    }

    @Override
    public List<Integer> getList() {
        return repo.getSoLuongSpTon();
    }

    @Override
    public List<Integer> getSoDonHoanNhap() {
        return repo.getSoDonHoanNhap();
    }

    @Override
    public List<Integer> getSoSanPhamDaNhap() {
        return repo.getSoSanPhamDaNhap();
    }

    @Override
    public List<Integer> getSoDonHoanXuat() {
        return repo.getSoDonHoanXuat();
    }

    @Override
    public List<Integer> getSoSanPhamDaXuat() {
        return repo.getSoSanPhamDaXuat();
    }

    @Override
    public List<TpThongKeSpCustom> getListSp() {
        return repo.getListSanPham();
    }

    @Override
    public List<TpThongKeSpCustom> getListByNgayThanhToan(Long ngayBatDau, Long ngayKetThuc) {
        return repo.getListByNgayThanhToan(ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<Integer> getSoLuongSpHoanNhap() {
        return repo.getSoLuongSpHoanNhap();
    }

    @Override
    public List<Integer> getSoLuongSpHoanXuat() {
        return repo.getSoDonHoanXuat();
    }

    @Override
    public List<TpThongKeSpCustom> phanTrang(List<TpThongKeSpCustom> list, int offset, int limit) {
        List<TpThongKeSpCustom> listPhanTrang = new ArrayList<>();
        int sum = limit + offset;
        if (list.size() <= sum) {
            sum = list.size();
        }
        for (int i = offset; i < sum; i++) {
            if (list.get(i) == null) {
                break;
            }
            TpThongKeSpCustom el = list.get(i);
            listPhanTrang.add(el);
        }
        return listPhanTrang;
    }

    @Override
    public List<TpThongKeSpCustom> findAllByKhAndNV(String ma, int rdo) {
        switch (rdo) {
            case 0:
             return repo.getListByMaHd(ma);
            case 1:
                return repo.getListByMaNv(ma);
            case 2:
               return repo.getListByTenNv(ma);
            default:
               return  repo.getListByTenNv("");
        
    }
    }
}
