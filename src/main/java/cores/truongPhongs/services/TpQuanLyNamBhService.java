/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.truongPhongs.services;

import cores.truongPhongs.customModels.TpQuanLyNamBhCustom;
import domainModels.NamBaoHanh;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Acer
 */
public interface TpQuanLyNamBhService {
    List<TpQuanLyNamBhCustom> getListNamBh();
    NamBaoHanh addNamBh(NamBaoHanh n);
    boolean updateNamBh(NamBaoHanh n);
    boolean deleteNamBh(UUID id);
    
}
