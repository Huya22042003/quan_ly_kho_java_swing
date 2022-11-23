/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.nhanVienQuanLy.customModels.NvqlLuongKiemKeCustom;
import domainModels.PhieuKiemKe;
import java.util.List;

/**
 *
 * @author window
 */
public interface NvqlLuongKiemKeService {
    public List<NvqlLuongKiemKeCustom> getAll();
    void Insert(NvqlLuongKiemKeCustom phieuKiemKe);
}
