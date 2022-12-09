/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TP_SanPhamCustom;
import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.customModels.TpThemSanPhamCustom;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author asus
 */
public interface TP_SanPhamService {
     public List<TpQuanLySanPhamCustom> getAll(String ten);

    TpQuanLySanPhamCustom addSanPham(TpQuanLySanPhamCustom custom);

    boolean updateSanPham(TP_SanPhamCustom custom);

    boolean deleteSanPham(UUID id);

    TpQuanLySanPhamCustom findSanPhamByMa(String ma);

    TpQuanLySanPhamCustom checkValidate(TpQuanLySanPhamCustom sp, JLabel erroMa, JLabel erroTen);
     
     List<TpQuanLySanPhamCustom> findAllByRadio(String tk, int rdo);

    List<TpQuanLySanPhamCustom> phanTrang(List<TpQuanLySanPhamCustom> list, int offset, int limit);
}
