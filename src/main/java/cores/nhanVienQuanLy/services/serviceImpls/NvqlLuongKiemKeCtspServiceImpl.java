/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import cores.nhanVienQuanLy.repositories.NvqlLuongKiemKeCtspRepository;
import cores.nhanVienQuanLy.services.NvqlLuongKiemKeCtspService;
import java.util.List;

/**
 *
 * @author window
 */
public class NvqlLuongKiemKeCtspServiceImpl implements NvqlLuongKiemKeCtspService{
    private NvqlLuongKiemKeCtspRepository rp;
    
    public NvqlLuongKiemKeCtspServiceImpl(){
        rp = new NvqlLuongKiemKeCtspRepository();
    }

    @Override
    public List<NvqlLuongKiemKeCtspCustom> getAll() {
        return rp.getAll();
    }
}
