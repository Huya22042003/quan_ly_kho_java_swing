/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienQuanLy.services.serviceImpls;

import cores.nhanVienQuanLy.customModels.NvghXemThongTinCaNhanCustom;
import cores.nhanVienQuanLy.repositories.NvghXemThongTinCaNhanRepository;
import cores.nhanVienQuanLy.services.NvghXemThongTinCaNhanService;
import java.util.List;

/**
 *
 * @author window
 */
public class NvghXemThongTinCaNhanServiceImpl implements NvghXemThongTinCaNhanService{

    private NvghXemThongTinCaNhanRepository nvghXemThongTinCaNhanRepository;

    public NvghXemThongTinCaNhanServiceImpl() {
        nvghXemThongTinCaNhanRepository = new NvghXemThongTinCaNhanRepository();
    }
    
    @Override
    public List<NvghXemThongTinCaNhanCustom> getAll() {
        return nvghXemThongTinCaNhanRepository.getAll();
    }

    @Override
    public void doiMatKhau(String pass) {
        nvghXemThongTinCaNhanRepository.doiMatKhau(pass);
    }

    @Override
    public boolean checkMatKhau(String matKhau) {
        return nvghXemThongTinCaNhanRepository.checkMatKhau(matKhau);
    }
    
}
