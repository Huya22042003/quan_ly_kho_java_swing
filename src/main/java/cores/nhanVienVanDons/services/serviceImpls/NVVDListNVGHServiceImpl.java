/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienVanDons.services.serviceImpls;

import cores.nhanVienVanDons.customModels.NVVDListNVGHCustom;
import cores.nhanVienVanDons.repositories.NVVDListNVGHRepository;
import cores.nhanVienVanDons.services.NVVDListNVGHService;
import java.util.List;

/**
 *
 * @author admin
 */
public class NVVDListNVGHServiceImpl implements NVVDListNVGHService{
    private NVVDListNVGHRepository repo;

    public NVVDListNVGHServiceImpl() {
        repo =new NVVDListNVGHRepository();
    }

    @Override
    public List<NVVDListNVGHCustom> getListNVGHByMa() {
        return repo.getListNVGHByMa();
    }
    
}
