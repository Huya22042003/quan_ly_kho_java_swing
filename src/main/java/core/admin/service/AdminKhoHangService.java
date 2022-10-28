/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.admin.service;

import core.admin.viewModel.AdminKhoHangCustom;
import infrastructure.constant.KhoHangConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author Acer
 */
public interface AdminKhoHangService {

    List<AdminKhoHangCustom> getListKhoHang();

    AdminKhoHangCustom saveKhoHang(AdminKhoHangCustom kh);

    void updateKhoHang(AdminKhoHangCustom kh);

    void deleteKhoHangById(UUID id);

    AdminKhoHangCustom checkValidate(JLabel errTen, String ten,String ma,KhoHangConstant tt,UUID idCoSo);
}
