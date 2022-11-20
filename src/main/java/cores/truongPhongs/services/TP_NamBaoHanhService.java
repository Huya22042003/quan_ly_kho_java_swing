
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TP_NamBaoHanhCustom;
import java.util.List;
import java.util.UUID;
import javax.swing.JLabel;


public interface TP_NamBaoHanhService {
    List<TP_NamBaoHanhCustom> getListNBH();
    TP_NamBaoHanhCustom addNBH(TP_NamBaoHanhCustom custom);
    boolean updateNBH(TP_NamBaoHanhCustom custom);
    boolean deleteNBH(UUID id);
    TP_NamBaoHanhCustom findNBHByMa(String ma);
    TP_NamBaoHanhCustom checkValidate(TP_NamBaoHanhCustom nbh, JLabel erroMa, JLabel erroTen);
    List<TP_NamBaoHanhCustom> findAllByRadio(String tk, int rdo);
}

