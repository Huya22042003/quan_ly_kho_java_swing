/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienVanDons.services.serviceImpls;

import cores.nhanVienVanDons.customModels.NvvdXemThongTinCaNhanCustom;
import cores.nhanVienVanDons.repositories.NvvdXemThongTinCaNhanRepository;
import cores.nhanVienVanDons.services.NvvdXemThongTinCaNhanService;
import java.util.List;

/**
 *
 * @author window
 */
public class NvvdXemThongTinCaNhanServiceImpl implements NvvdXemThongTinCaNhanService {

    private NvvdXemThongTinCaNhanRepository nvvdXemThongTinCaNhanRepository;

    public NvvdXemThongTinCaNhanServiceImpl() {
        nvvdXemThongTinCaNhanRepository = new NvvdXemThongTinCaNhanRepository();
    }

    @Override
    public List<NvvdXemThongTinCaNhanCustom> getAll() {
        return nvvdXemThongTinCaNhanRepository.getAll();
    }

    @Override
    public void doiMatKhau(String pass) {
        nvvdXemThongTinCaNhanRepository.doiMatKhau(pass);
    }

    @Override
    public boolean checkMatKhau(String matKhau) {
        return nvvdXemThongTinCaNhanRepository.checkMatKhau(matKhau);
    }

}
