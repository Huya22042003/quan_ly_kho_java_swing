/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.admins.services.serviceImpls;

import cores.admins.customModels.AdQuanLyLoaiHangCustom;
import cores.admins.repositories.AdQuanLyLoaiHangRepository;
import cores.admins.services.AdQuanLyLoaiHangService;
import domainModels.LoaiHang;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class AdQuanLyLoaiHangServiceImpl implements AdQuanLyLoaiHangService {

    private AdQuanLyLoaiHangRepository repo;

    public AdQuanLyLoaiHangServiceImpl() {
        repo = new AdQuanLyLoaiHangRepository();
    }

    @Override
    public List<AdQuanLyLoaiHangCustom> getList() {
        return repo.getList();
    }

    @Override
    public AdQuanLyLoaiHangCustom InsertLoaiHangById(AdQuanLyLoaiHangCustom lhcm) {
        LoaiHang lh = new LoaiHang();
        lh.setMa(lhcm.getMa());
        lh.setTen(lhcm.getTen());
        lh.setMoTa(lhcm.getMoTa());
        lh.setGia(lhcm.getGia());
        lhcm.setId(repo.InsertLoaiHangById(lh).getId());
        return lhcm;
    }

    @Override
    public boolean UpdateLoaiHangById(AdQuanLyLoaiHangCustom lhcm) {
        LoaiHang lh = new LoaiHang();
        lh.setMa(lhcm.getMa());
        lh.setTen(lhcm.getTen());
        lh.setMoTa(lhcm.getMoTa());
        lh.setGia(lhcm.getGia());
        lh.setId(lhcm.getId());
        return repo.UpdateLoaiHangById(lh);
        
    }

    @Override
    public boolean DeleteLoaiHangById(UUID id) {
        return repo.DeleteLoaiHangById(id);
    }

}
