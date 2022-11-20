/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpNhanVienCustom;
import infrastructures.constant.TrangThaiNhanVienConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;

/**
 *
 * @author LENOVO
 */
public interface TpQuanLyNhanVienSevice {

    List<TpNhanVienCustom> getListNhanVien();

    TpNhanVienCustom addNhanVien(TpNhanVienCustom ct);

    boolean updateNhanVien(TpNhanVienCustom ct);

    boolean deleteNhanVien(UUID id);

    void loadCombobox(Combobox cbb);

    TpNhanVienCustom checkValidate(TpNhanVienCustom nv, JLabel erroMa, JLabel erroTen,
            JLabel erroSDT, JLabel erroEmail, JLabel erroMatKhau,
            JLabel erroNgaySinh, JLabel erroDiaChi);

    TrangThaiNhanVienConstant loc(int a);

    TpNhanVienCustom finNhanVienByMa(String ma);

    List<TpNhanVienCustom> findAllByRadio(String ten, TrangThaiNhanVienConstant tt, int rdo);
}
