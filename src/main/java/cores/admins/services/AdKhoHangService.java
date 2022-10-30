/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.admins.services;

import cores.admins.customModels.AdKhoHangCustom;
import infrastructures.constant.KhoHangConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author Acer
 */
public interface AdKhoHangService {
    
    List<AdKhoHangCustom> getListKhoHang();

    AdKhoHangCustom saveKhoHang(AdKhoHangCustom kh);

    void updateKhoHang(AdKhoHangCustom kh);

    void deleteKhoHangById(UUID id);

    AdKhoHangCustom checkValidate(JLabel errTen, String ten,String ma,String tt,UUID idCoSo);
}
