/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpDonViCustom;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public interface TpDonViService {

    List<TpDonViCustom> getListDonVi();

    TpDonViCustom addDonVi(TpDonViCustom custom);

    boolean updateDonVi(TpDonViCustom custom);

    boolean deleteDonVi(UUID id);

//    TpDonViCustom checkValidate(TpDonViCustom dv, JLabel erroDonViGoc, JLabel erroDonViQuyDoi, JLabel erroSoLuong);
    TpDonViCustom checkValidate(String DonViGoc, String DonViQuyDoi, String SoLuong, JLabel erroDonViGoc, JLabel erroDonViQuyDoi, JLabel erroSoLuong);

    TpDonViCustom findDonViByDonViQuyDoi(String donViQuyDoi);

    List<TpDonViCustom> findAllByRadio(String donViGoc, int rdo);

}
