/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import customModels.DemoCoSoCustom;
import infrastructures.constant.CoSoConstant;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;
import utilities.palette.Combobox;

/**
 *
 * @author QUOC HUY
 */
public interface DemoCoSoService {
    List<DemoCoSoCustom> getListCoSo();
    DemoCoSoCustom addCoSo(DemoCoSoCustom custom);
    boolean updateCoSo(DemoCoSoCustom custom);
    boolean deleteCoSo(UUID id);
    void loadCombobox(Combobox cbb);
    DemoCoSoCustom checkValidate(DemoCoSoCustom cs, JLabel erroMa, JLabel erroTen, JLabel erroViTri);
    CoSoConstant loc(int a);
    DemoCoSoCustom findCoSoByMa(String ma);
}
