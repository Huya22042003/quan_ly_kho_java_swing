/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpQuanLySanPhamCustom;
import cores.truongPhongs.repositories.TpQuanLySanPhamRepository;
import domainModels.SanPham;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author MMC
 */
public interface TpQuanLySanPhamService {

    public List<TpQuanLySanPhamCustom> getAll();

    TpQuanLySanPhamCustom addSanPham(TpQuanLySanPhamCustom custom);

    boolean updateSanPham(TpQuanLySanPhamCustom custom);

    boolean deleteSanPham(UUID id);

    TpQuanLySanPhamCustom findSanPhamByMa(String ma);

    List<TpQuanLySanPhamCustom> findAllByRadio(String ten, int rdo);

    TpQuanLySanPhamCustom checkValidate(TpQuanLySanPhamCustom sp, JLabel erroMa, JLabel erroTen);

    public SanPham findID(UUID id);
}
