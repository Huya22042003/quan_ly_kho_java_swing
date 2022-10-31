/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cores.admins.services;

import cores.admins.customModels.AdQuanLyLoaiHangCustom;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author admin
 */
public interface AdQuanLyLoaiHangService {
    List<AdQuanLyLoaiHangCustom> getList();
    AdQuanLyLoaiHangCustom InsertLoaiHangById(AdQuanLyLoaiHangCustom lhcm);
    boolean UpdateLoaiHangById(AdQuanLyLoaiHangCustom lhcm);
    boolean DeleteLoaiHangById(UUID id);
}
