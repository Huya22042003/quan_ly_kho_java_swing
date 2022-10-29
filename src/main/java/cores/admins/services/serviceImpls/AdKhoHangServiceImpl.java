/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.admins.services.serviceImpls;

import cores.admins.customModels.AdKhoHangCustom;
import cores.admins.repositories.AdCoSoRepository;
import cores.admins.repositories.AdKhoHangRepository;
import cores.admins.services.AdKhoHangService;
import domainModels.CoSo;
import domainModels.KhoHang;
import infrastructures.constant.KhoHangConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author Acer
 */
public class AdKhoHangServiceImpl implements AdKhoHangService{
    private AdKhoHangRepository repoKhoHang;
    private AdCoSoRepository repoCoSo;

    public AdKhoHangServiceImpl() {
        repoCoSo = new AdCoSoRepository();
        repoKhoHang = new AdKhoHangRepository();
    }
    
    @Override
    public List<AdKhoHangCustom> getListKhoHang() {
        return repoKhoHang.getListKhoHang();
    }

    @Override
    public AdKhoHangCustom saveKhoHang(AdKhoHangCustom kh) {
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
    public void updateKhoHang(AdKhoHangCustom kh) {
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
    public AdKhoHangCustom checkValidate(JLabel errTen, String ten, String ma, KhoHangConstant tt, UUID idCoSo) {
           int i = 0;
        if(ten.trim().length() == 0){
                errTen.setText("Bạn phải nhập tên!");
                i++;
        }
        if(i!=0){
            return null;
        }
        
        AdKhoHangCustom kh = new AdKhoHangCustom();
        kh.setIdCoSo(idCoSo);
        kh.setMa(ma);
        kh.setTrangThai(tt);
        kh.setTen(ten);
        return kh;
    }
    
}
