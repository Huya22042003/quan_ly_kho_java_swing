/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services;

import cores.logins.custom.NhanVienCustom;
import cores.nhanVienQuanLy.customModels.NvqlXemThongTinCaNhanCustom;
import java.util.List;

/**
 *
 * @author window
 */
public interface NvqlXemThongTinCaNhanService {
    public List<NvqlXemThongTinCaNhanCustom> getAll();
    public void doiMatKhau(NhanVienCustom nvc);
    public boolean checkMatKhau(String matKhau);
}
