/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCtspCustom;
import java.util.List;

/**
 *
 * @author window
 */
public interface NvqlLuongKiemKeCtspService {
    public List<NvqlLuongKiemKeCtspCustom> getAll();
    
    public void updateSoLuong(NvqlLuongKiemKeCtspCustom nvqlLuongKiemKeCtpkService);
}
