/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.admin.service.serviceImpl;

import core.admin.repository.AdminCoSoRepository;
import core.admin.repository.AdminKhoHangRepository;
import core.admin.service.AdminKhoHangService;
import core.admin.viewModel.AdminKhoHangCustom;
import domainModel.CoSo;
import domainModel.KhoHang;
import infrastructure.constant.KhoHangConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author Acer
 */
public class AdminKhoHangServiceImpl implements AdminKhoHangService {

    private AdminKhoHangRepository repoKhoHang;
    private AdminCoSoRepository repoCoSo;

    public AdminKhoHangServiceImpl() {
        repoKhoHang = new AdminKhoHangRepository();
        repoCoSo = new AdminCoSoRepository();
    }

    @Override
    public List<AdminKhoHangCustom> getListKhoHang() {
        return repoKhoHang.getListKhoHang();
    }

    @Override
    public AdminKhoHangCustom saveKhoHang(AdminKhoHangCustom kh) {
        CoSo cs = repoCoSo.findCoSoById(kh.getIdCoSo());
        KhoHang kh1 = new KhoHang();
        kh1.setMa(kh.getMa());
        kh1.setTen(kh.getTen());
        kh1.setTrangThai(kh.getTrangThai());
        kh1.setIdCoSo(cs);
        kh.setId(repoKhoHang.saveKhoHang(kh1).getId());
        return kh;

    }

    @Override
    public void updateKhoHang(AdminKhoHangCustom kh) {
        CoSo cs = repoCoSo.findCoSoById(kh.getIdCoSo());
        KhoHang kh1 = new KhoHang();
        kh1.setMa(kh.getMa());
        kh1.setTen(kh.getTen());
        kh1.setTrangThai(kh.getTrangThai());
        kh1.setIdCoSo(cs);
        kh1.setId(kh.getId());
        repoKhoHang.updateKhoHang(kh1);
        
    }

    @Override
    public void deleteKhoHangById(UUID id) {
        repoKhoHang.deleteKhoHangById(id);
    }

    @Override
    public AdminKhoHangCustom checkValidate(JLabel errTen, String ten,String ma,KhoHangConstant tt,UUID idCoSo) {
           int i = 0;
        if(ten.trim().length() == 0){
                errTen.setText("Bạn phải nhập tên!");
                i++;
        }
        if(i!=0){
            return null;
        }
        
        AdminKhoHangCustom kh = new AdminKhoHangCustom();
        kh.setIdCoSo(idCoSo);
        kh.setMa(ma);
        kh.setTrangThai(tt);
        kh.setTen(ten);
        return kh;
    }

}
