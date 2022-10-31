/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienGiaoHangs.services;

import cores.khachHangs.customModels.NvghXemThongTinCaNhanCustom;
import java.util.List;

/**
 *
 * @author window
 */
public interface NvghXemThongTinCaNhanService {
    public List<NvghXemThongTinCaNhanCustom> getAll();
    public void doiMatKhau(String pass);
    public boolean checkMatKhau(String matKhau);
}
