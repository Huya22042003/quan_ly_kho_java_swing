/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpXemThongTinCaNhanCustom;
import java.util.List;

/**
 *
 * @author window
 */
public interface TpXemThongTinCaNhanService {
    public List<TpXemThongTinCaNhanCustom> getAll();
    public void doiMatKhau(String pass);
    public boolean checkMatKhau(String matKhau);
}
