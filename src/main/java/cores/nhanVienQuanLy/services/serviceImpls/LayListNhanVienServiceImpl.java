/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.LayListNhanVienCustom;
import cores.nhanVienQuanLy.repositories.LayListNhanVienRepository;
import cores.nhanVienQuanLy.services.LayListNhanVienService;
import java.util.List;

/**
 *
 * @author admin
 */
public class LayListNhanVienServiceImpl implements LayListNhanVienService{
    private LayListNhanVienRepository rp;

    public LayListNhanVienServiceImpl() {
        rp = new LayListNhanVienRepository();
    }
    
    @Override
    public List<LayListNhanVienCustom> getList() {
        return rp.getList();
    }
    
}
