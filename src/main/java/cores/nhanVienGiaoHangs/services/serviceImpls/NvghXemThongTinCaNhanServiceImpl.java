/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.nhanVienGiaoHangs.services.serviceImpls;

import cores.khachHangs.customModels.NvghXemThongTinCaNhanCustom;
import cores.nhanVienGiaoHangs.repositories.NvghXemThongTinCaNhanRepository;
import cores.nhanVienGiaoHangs.services.NvghXemThongTinCaNhanService;
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
