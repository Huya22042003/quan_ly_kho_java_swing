/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cores.truongPhongs.services.serviceImpls;

import cores.truongPhongs.customModels.TpXemThongTinCaNhanCustom;
import cores.truongPhongs.repositories.TpXemThongTinCaNhanRepository;
import cores.truongPhongs.services.TpXemThongTinCaNhanService;
import java.util.List;

/**
 *
 * @author window
 */
public class TpXemThongTinCaNhanServiceImpl implements TpXemThongTinCaNhanService{

    private TpXemThongTinCaNhanRepository tpXemThongTinCaNhanRepository;

    public TpXemThongTinCaNhanServiceImpl() {
        tpXemThongTinCaNhanRepository = new TpXemThongTinCaNhanRepository();
    }
    
    @Override
    public List<TpXemThongTinCaNhanCustom> getAll() {
        return tpXemThongTinCaNhanRepository.getAll();
    }

    @Override
    public void doiMatKhau(String pass) {
        tpXemThongTinCaNhanRepository.doiMatKhau(pass);
    }

    @Override
    public boolean checkMatKhau(String matKhau) {
        return tpXemThongTinCaNhanRepository.checkMatKhau(matKhau);
    }
    
}
