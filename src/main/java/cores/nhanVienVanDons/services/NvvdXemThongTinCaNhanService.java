/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienVanDons.services;

import cores.nhanVienVanDons.customModels.NvvdXemThongTinCaNhanCustom;
import java.util.List;

/**
 *
 * @author window
 */
public interface NvvdXemThongTinCaNhanService {
    public List<NvvdXemThongTinCaNhanCustom> getAll();
    public void doiMatKhau(String pass);
    public boolean checkMatKhau(String matKhau);
}
