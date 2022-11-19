/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.LayListKhachHangCustom;
import cores.nhanVienQuanLy.repositories.LayListKhachHangRepository;
import cores.nhanVienQuanLy.services.LayListKhachHangService;
import java.util.List;

/**
 *
 * @author admin
 */
public class LayListKhachHangServiceImpl implements LayListKhachHangService{
    private LayListKhachHangRepository rp;

    public LayListKhachHangServiceImpl() {
        rp = new LayListKhachHangRepository();
    }
    
    @Override
    public List<LayListKhachHangCustom> getList() {
        return rp.getList();
    }
    
}
