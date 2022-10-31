/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.khachHangs.services;

import cores.khachHangs.customModels.KhXemThongTinCaNhanCustom;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author window
 */
public interface KhXemThongTinCaNhanService {
    public List<KhXemThongTinCaNhanCustom> getAll();
    public void doiMatKhau(String pass);
    public boolean checkMatKhau(String matKhau);
}
